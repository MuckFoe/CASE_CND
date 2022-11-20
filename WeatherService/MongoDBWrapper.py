import logging
import time
from JsonConfigReader import JsonConfigReader
from pymongo import MongoClient
from Utils import round_unix_date, download_weather_data_from_api


class ElasticSearchClient:
    """
    Wrapper Class for the elasticsearch client
    offers all functionality concerning communication with the elasticsearch server
    """

    def __init__(self):
        """
        constructor which crates ElasticSearchClient with the elasticsearch
        url from the config file
        """
        self.config_reader = JsonConfigReader()
        self.mongodb_url = self.config_reader.get_config_value('mongodb_url')
        self.mongodb_port = self.config_reader.get_config_value('mongodb_port')
        self.mongodb_database = self.config_reader.get_config_value('mongodb_database')

        logging.info('Init mongodb client with url: ' +
                     self.mongodb_url + ':' + self.mongodb_port)

        self.mongo_client = MongoClient()

    def get_mongo_client(self):
        """ Returns a mongo client instance 

        Returns:
            MongoClient: returns an instance of configured mongo client
        """
        return self.client

    def insert_document(self, database, collection, document):
        """Inserts a given singular document into the specified collection in the specified database
        After inserting returns the object id of the document now stored in mongodb

        Args:
            database (String): database name
            collection (String): collection name
            document (dict): obeject to be inserted

        Returns:
            String: object_id of the inserted document
        """
        self.init_database(database)
        self.init_collection(collection)
        object_id = self.collection.insert_one(document)
        return object_id

    def init_database(self, database_name):
        """Initialize mongo db database by name

        Args:
            database_name (String): database name

        Returns:
            database: mongo db database
        """
        self.database = self.client[database_name]
        return self.database

    def init_collection(self, collection_name):
        """Initialize mongo db collection by name
        To use this function first off you need to initialize the specific database 
        Otherwise this will return an error

        Args:
            collection_name (String): collection name

        Returns:
            collection: mongo db collection
        """
        if self.database is not None:
            self.collection = self.database[collection_name]
            return self.collection
        else:
            raise BaseException("Database not initialized")

    def search_weather_data_by_city_with_timestamp(self, city, start_time, end_time):
        """
        search elastic search for weather data of a specific city and specific time frame
        supplying upper and lower boundaries of time
        :param start_time: lower boundary
        :param end_time: upper boundary
        :param city: the city you want to search for
        :return: hits field from es response - list format - maybe empty
        """
        query = '{"query":{"bool":{"must":[{"match": {"name": "' + city + '"}},{"range": {"dt": {"gte": "' + str(
            start_time) + '","lte": "' + str(end_time) + '"}}}]}}}'
        result = self.es_client.search(index='weather_data', body=query)
        return result['hits']['hits']

    def search_weather_data_by_city_today(self, city):
        """
        search elasticsearch for weather data of a specific city and current day
        :param city: the city you want to search for
        :return: hits field from es response - list format - maybe empty
        """
        seconds_in_day = 60 * 60 * 24
        timestamp_today = int(round(time.time()))
        timestamp_today_round_up = round_unix_date(
            timestamp_today, seconds_in_day, True)
        timestamp_today_round_down = round_unix_date(
            timestamp_today, seconds_in_day, False)
        return self.search_weather_data_by_city_with_timestamp(city, timestamp_today_round_down,
                                                               timestamp_today_round_up)

    def get_weather_data_by_city_and_timestamp(self, city, start_time, end_time):
        """
        get weather data for a specific city
        first searches es for data and if the data isn't stored yet
        downloads the new data and indexes it to elasticsearch to reduce amount of requests
        :param end_time: upper time boundary for search
        :param start_time: lower time boundary for search
        :param city: string of city name
        :return:
        """
        result = self.search_weather_data_by_city_with_timestamp(
            city=city, start_time=start_time, end_time=end_time)
        if not result:
            return result
        return result[0]['_source']

    def get_weather_data_by_city(self, city, federal_state, border=None):
        """
        get weather data for a specific city
        first searches es for data and if the data isn't stored yet
        downloads the new data and indexes it to elasticsearch to reduce amount of requests
        :param city: string of city name
        :param federal_state: federal state of the city 
        :param border: optional border of the state
        :return:
        """
        api_key = os.getenv('OPEN_WEATHER_API_KEY')
        result = self.search_weather_data_by_city_today(city=city)
        if not result:
            result = download_weather_data_from_api(city, api_key=api_key)
            result['federal_state'] = federal_state
            result['border'] = border
            self.index_weather_data(result)
            return result
        return result[0]['_source']

    def index_weather_data(self, weather_json):
        """
        index weather data to elasticsearch
        :return: None
        """
        self.es_client.index(index='weather_data', body=weather_json,
                             doc_type='_doc')

    def get_unique_cities(self):
        """
        Search unique cities in in weather_data index
        :return:  a list of cities
        """
        query = '{"size":0,"aggs":{"unique_cities":{"terms":{"field":"name.keyword"}}}}'
        result = self.es_client.search(index='weather_data', body=query)
        return result['aggregations']['unique_cities']['buckets']

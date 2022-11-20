import datetime
import uuid
import requests


from JsonConfigReader import *
from Utils import *


class WeatherProvider():
    def __init__(self) -> None:
        self.last_request_time = None
        self.weather_data = None
        self.weather_provider_id = str(uuid.uuid4())
        self.config_reader = JsonConfigReader()
        self.current_city = self.config_reader.get_config_value(
            'standard_city')
        self.weather_lease_time = self.config_reader.get_config_value(
            'weather_lease_time')
        self.get_weather_object_from_openweatherapi()

    def get_weather_info(self):
        if self.last_request_time > int(datetime.datetime.now().strftime("%Y%m%d%H%M%S")) + self.weather_lease_time:
            self.get_weather_object_from_openweatherapi()
        return self.weather_data

    def update_city(self, city):
        self.current_city = city
        self.get_weather_object_from_openweatherapi()

    def get_weather_object_from_openweatherapi(self):
        """
        download weather data for a specific city through openweatherapi with a rest request
        :param city: the city the weather data should be about
        :return: the weather data as a json object
        """
        build_url = 'http://api.openweathermap.org/data/2.5/weather?q=' + \
                    self.current_city + '&appid=' + \
                    os.getenv('OPEN_WEATHER_API_KEY') + '&units=metric'
        res = requests.get(build_url).json()
        res = replace_all_mutated_vowels(res)
        self.last_request_time = int(
            datetime.datetime.now().strftime("%Y%m%d%H%M%S"))
        self.weather_data = res

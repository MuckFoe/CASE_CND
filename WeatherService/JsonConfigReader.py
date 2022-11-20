import json
import os


class JsonConfigReader():
    """JsonConfigReader class that reads the Config on init
    """

    def __init__(self):
        # read config on init

        with open(os.getenv('CONFIG_PATH_WEATHER_SERVICE'), 'r') as config_file:
            self.data = json.load(config_file)

    def get_config_value(self, *key):
        """Generic funtcion to get a value from the config
        Takes any amount of keys to specify the exact value u want to have

        {
            'value' : 3,
            'outer' :
            {
                'inner' : 4
            }

        }
        to acces outer get_config_value('value')
        to acces outer get_config_value('outer', 'inner')
        and so on if dict is stacked more

        Returns:
            [no specific type]: returns the requested config value
        """
        if len(key) > 0:
            json_config = self.data
            for elem in key:
                json_config = json_config[elem]
            return json_config
        return self.data[key[0]]

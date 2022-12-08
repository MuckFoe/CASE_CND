import flask

from WeatherProvider import WeatherProvider
from JsonConfigReader import JsonConfigReader

app = flask.Flask(__name__)
weather_provider = WeatherProvider()
config_reader = JsonConfigReader()


@app.route('/health')
def success(name):
    return 1


@app.route('/weather', methods=['POST', 'GET'])
def weather_request():
    if flask.request.method == 'POST':
        city = flask.request.headers.get('city')
        weather_provider.update_city(city)
        return city
    else:
        return weather_provider.get_weather_info()


if __name__ == '__main__':
    app.run(debug=False, host='0.0.0.0',
            port=config_reader.get_config_value('application_port'))

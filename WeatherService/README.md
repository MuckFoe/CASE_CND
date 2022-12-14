# WeatherService


### Run Native

To run the WeatherService natively you need to have python installed.

This can be established using the guide [here](https://realpython.com/installing-python/)

After that we will create a virtual environment. A guide can be found [here](https://www.freecodecamp.org/news/how-to-setup-virtual-environments-in-python/)

With the virtual environment activated (see the guide above) all dependencies of the WeatherService can be installed using:

`pip install -r requirements.txt`

The service itself needs to environment variables:
 * `CONFIG_PATH_WEATHER_SERVICE`, the path to the config file (an example is in the main directory of the WeatherService)
 * `OPEN_WEATHER_API_KEY`, storse api key for [openweathermap](https://openweathermap.org/)
 * `FLASK_APP = WeatherService` specifiy the main app for flask
 * `FLASK_RUN_PORT` the port for flask to run on - as a standard you should use `50505`
 * `FLASK_RUN_HOST` the address to bind to in docker context you should use `0.0.0.0`

Such variables can be set using this [guide](https://www.twilio.com/blog/2017/01/how-to-set-environment-variables.html)
To finally start the service run:

`python __main__.py`

This will start the internal flask server which answers all incoming calls.
### Run with Docker
To run the WeatherService using Docker you first need to build the container using following command from the WeatherService directory:

`docker build -t case-weatherservice ./`

Afterwards you can run the service using the following command:

`docker run -d -p 50505:50505 --name case-weatherservice -e CONFIG_PATH_WEATHER_SERVICE="/usr/caseweatherservice/src/Config.json" -e OPEN_WEATHER_API_KEY=""  -e FLASK_APP="WeatherService" -e FLASK_RUN_PORT="50505" -e FLASK_RUN_HOST="0.0.0.0" --network=case case-weatherservice`

The two environment variables are used for the config file as well as the open weather api key.
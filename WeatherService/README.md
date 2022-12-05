# WeatherService


### Run natively
To run the WeatherService natively 
### Run with Docker
To run the WeatherService using Docker you first need to build the container using following command from the WeatherService directory:

`docker build -t caseweatherservice ./`

Afterwards you can run the service using the following command:

`docker run -d -p 50505:50505 --name caseweatherservice -e CONFIG_PATH_WEATHER_SERVICE="/usr/caseweatherservice/src/Config.json" -e OPEN_WEATHER_API_KEY="" caseweatherservice`

The two environment variables are used for the config file as well as the open weather api key.
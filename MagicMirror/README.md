# MagicMirror


### Run Native

To run the WeatherService natively you need to have python installed.

This can be established using the guide [here](https://realpython.com/installing-python/)

After that we will create a virtual environment. A guide can be found [here](https://www.freecodecamp.org/news/how-to-setup-virtual-environments-in-python/)

With the virtual environment activated (see the guide above) all dependencies of the WeatherService can be installed using:

`pip install -r requirements.txt`

!Attention to actually access the web ui, the EventService needs to be running to display data

When startup is done you should be able to visit the website [here](http://127.0.0.1:8000/magicui)

Configuration wise settings can be updated under `./magicmirror/settings.py`. 

Most importantly the connection strings to the local or not local EventService and WeatherService, which are specified by the value `EVENT_SERVICE_BASE_PATH` and `WEATHER_SERVICE_BASE_PATH` respectively, need to be set. Both of them are environment variables.

Such variables can be set using this [guide](https://www.twilio.com/blog/2017/01/how-to-set-environment-variables.html)


Finally the MagicMirror can be run using the following command

`python manage.py runserver 0.0.0.0:8000`

### Run with Docker
To run the WeatherService using Docker you first need to build the container using following command from the WeatherService directory:

`docker build -t casemagicmirror ./`

Afterwards you can run the service using the following command:

`docker run -d -p 8000:8000 --name casemagicmirror -e DJANGO_SETTINGS_MODULE="magicmirror.settings" --network=case casemagicmirror`

The standard config is build to run within the docker context so it shouldn't be necessary to change it.
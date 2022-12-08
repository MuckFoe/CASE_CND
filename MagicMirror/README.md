# MagicMirror


### Run Native

To run the WeatherService natively you need to have python installed.

This can be established using the guide [here](https://realpython.com/installing-python/)

After that we will create a virtual environment. A guide can be found [here](https://www.freecodecamp.org/news/how-to-setup-virtual-environments-in-python/)

With the virtual environment activated (see the guide above) all dependencies of the WeatherService can be installed using:

`pip install -r requirements.txt`

Finally the MagicMirror can be run using the following command

`python manage.py runserver`

!Attention to actually access the web ui, the EventService needs to be running to display data

When startup is done you should be able to visit the website [here](http://127.0.0.1:8000/magicui)

### Run with Docker
To run the WeatherService using Docker you first need to build the container using following command from the WeatherService directory:

`docker build -t magicmirror ./`

Afterwards you can run the service using the following command:

`docker run -d -p 8000:8000 --name magicmirror magicmirror`

The two environment variables are used for the config file as well as the open weather api key.
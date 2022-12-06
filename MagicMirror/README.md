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
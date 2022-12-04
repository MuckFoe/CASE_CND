FROM python:3.6


#Labels as key value pair
LABEL Maintainer="moritz.zeitler"


# Chose the workin directory
WORKDIR /usr/WeatherService/src

#to COPY the remote file at working directory in container
COPY ./* ./
# Now the structure looks like this '/usr/app/src/test.py'

RUN pip install --no-cache-dir --upgrade pip && \
    pip install --no-cache-dir requests elasticsearch==6.8.2 pandas

#CMD instruction should be used to run the software
#contained by your image, along with any arguments.
CMD [ "python", "./__main__.py"]
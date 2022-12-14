FROM python:3.6

#Labels as key value pair
LABEL Maintainer="moritz.zeitler"

# Chose the workin directory
WORKDIR /usr/caseweatherservice/src

# Copy necessary files for WeatherService
COPY ./WeatherService.py ./
COPY ./JsonConfigReader.py ./
COPY ./Utils.py ./
COPY ./WeatherProvider.py ./
COPY ./Config.json ./

# Upgrade pip and install flask
RUN pip install --no-cache-dir --upgrade pip && \
    pip install --no-cache-dir flask requests

# Run the python main function to start CaseWeatherService
CMD [ "flask", "run"]
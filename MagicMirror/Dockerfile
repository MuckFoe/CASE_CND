FROM python:3.6


#Labels as key value pair
LABEL Maintainer="moritz.zeitler"

# set environment variables  
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1  

# Chose the workin directory
WORKDIR /usr/magicmirror/src

# Copy necessary files for MagicMirror
COPY ./magicmirror ./magicmirror
COPY ./magicui ./magicui
COPY ./manage.py ./
COPY ./requirements.txt ./

# Upgrade pip and install flask
RUN pip install --no-cache-dir --upgrade pip && \
    pip install --no-cache-dir django requests

# Run the python main function to start MagicMirror
CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]
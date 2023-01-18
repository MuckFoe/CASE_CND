import requests
import json
import os

from requests.exceptions import ConnectionError

from django.shortcuts import render
from django.template import loader
from django.http import HttpResponse
from django.conf import settings


def index(request):
    try:
        todays_events_list = requests.get(
            settings.EVENT_SERVICE_BASE_PATH + 'events/today').json()
        weather_data = requests.get(
            settings.WEATHER_SERVICE_BASE_PATH + 'weather').json()
    except Exception as e:
        todays_events_list = []
        print(str(e))
    context = {
        'todays_events_list': todays_events_list,
        'weather_data' : json.dumps(weather_data, indent=2)
    }
    return render(request, 'index.html', context)


def detail(request, event_id):
    event = None
    try:
        event = requests.get(
            settings.EVENT_SERVICE_BASE_PATH + 'events/{}'.format(event_id)).json()
        calender = requests.get(
            settings.EVENT_SERVICE_BASE_PATH + 'calendertype/name={}'.format(event['calenderName'])).json()
    except ConnectionError as e:
        print(str(e))
    if event:
        context = {
            'event_name': event['name'],
            'event_start_time': event['startTime'],
            'event_end_time': event['endTime'],
            'event_place': event['place'],
            'event_calender_name': event['calenderName'],
            'event_description': event['description'],
            'calender_color': calender['hexColor']
        }
    else:
        context = {
            'event_name': None,
            'event_start_time': None,
            'event_end_time': None,
            'event_place': None,
            'event_calender_name': None,
            'event_description': None,
            'calender_color': None
        }
    return render(request, 'detail.html', context)

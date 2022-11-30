import requests
import json

from django.shortcuts import render
from django.template import loader
from django.http import HttpResponse


def index(request):
    todays_events_list = requests.get(
        'http://localhost:8080/api/events/today').json()
    context = {
        'todays_events_list': todays_events_list
    }
    return render(request, 'index.html', context)


def detail(request, event_id):
    event = requests.get(
        'http://localhost:8080/api/events/{}'.format(event_id)).json()
    calender = requests.get('http://localhost:8080/api/calendertype/name={}'.format(event['calenderName'])).json()
    context = {
        'event_name': event['name'],
        'event_start_time': event['startTime'],
        'event_end_time': event['endTime'],
        'event_place': event['place'],
        'event_calender_name': event['calenderName'],
        'event_description': event['place'],
        'calender_color' : calender['hexColor']
    }
    return render(request, 'detail.html', context)

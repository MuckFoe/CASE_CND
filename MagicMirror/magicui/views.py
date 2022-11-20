import requests
import json

from django.shortcuts import render
from django.template import loader
from django.http import HttpResponse


def index(request):
    todays_events_list = requests.get(
        'http://localhost:8080/api/events/today').json()
    print(todays_events_list)
    context = {
        'todays_events_list': todays_events_list
    }
    return render(request, 'index.html', context)

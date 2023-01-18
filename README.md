# CASE 

## Run with Docker Compose
The container configs are based on docker images.

This means with just building the containers, the docker-compose file should be enough to run the whole system. On how to build the containers specifically: Go to the corresponding folders `README.md` and follow the steps in there.

This means to start the whole system, use: 

`docker-compose up -d`.

## Run with Kubernetes

To run the application(s) using kubernetes you have to have kubernetes as well as working ingress installed.

After those prerequisites are met you can run the application using:

`kubectl apply -f ./k8s/mongo`

And:

`kubectl apply -f .k8s/applications`


## Usage

### In case of `docker compose`:

The UI is accessible from:

`localhost:12345/magicui`

To ingest events you can you use following curl command:

`curl -X POST localhost:12345/api/events -H "Content-Type: application/json" -d '{"name":"test_event3","description":"test_description","calenderName":"test_calender2","startTime":"2022-01-08T21:57:30.389142200","endTime":"2023-02-25T22:57:30.389142200","place":"realplace"}'`

To change the location of the weather service (Ingolstadt is the standard):

`curl -X POST localhost:12345/weather -H "city:Mainz"`

For the weather service to work you need to supply a working api key from [openweathermap](https://openweathermap.org/). But even without the service will work the same, only the output is an error msg instead of weather data.

### In case of `kubernetes`:
The paths stay the same, just delete the port from the requests. Usage should be the same - hopefully.

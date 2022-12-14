# Event Service

This API is used to save events and search for them. 

## Deployment
## Run Native
### Prerequisites  
The machine running this API needs to have at least a JRE installed. A guide to install Java can be found [here](https://docs.oracle.com/goldengate/1212/gg-winux/GDRAD/java.htm#BGBFJHAB)

To persist data using this API a running MongoDB is needed. To install the MongoDB you can use a docker container or use the native installation guide [here](https://www.mongodb.com/docs/manual/installation/).

Alternatively you can start your MongoDB with docker using this command:

`docker run --name casemongo --network case -p 27018:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -d mongo`

After that you can run the application using these commands: 

#### Windows:

`java -jar .\EventService-1.0.jar --spring.config.name=application --spring.config.location="C:\Path\to\this\folder\CASE_CND\EventService\config\"`

#### Unix like:

`java -jar .\EventService-1.0.jar --spring.config.name=application --spring.config.location="/Path/to/this/folder/CASE_CND/EventService/config/"`

The two parameters other than the fat-jar path, supply the folder path, where to find the config files for the application.
A predefined file for this config can be found at 'EventService/config/spring.application.yml'. Keep in mind that you have to configure the MongoDB URL and Port. As of now it uses standard port on localhost: `localhost:27017`.

If the MongoDB is running, and only if its running and the config for the MongoDB is correct, you can start the EventService using the command above.
### Building the Application
If you want to build the Application from scratch you have to install maven. A guide on how to do this can be found [here](https://maven.apache.org/install.html).

Also the java version has to be version 15.

With maven installed you can run 'mvn package' to build the application. This will produce a fat jar the holds all dependencies and can be started using the commands found in [Prerequisites](#prerequisites).
## Run with Docker
To run the WeatherService using Docker you first need to build the container using following command from the WeatherService directory:

`docker build -t case-eventservice ./`

Afterwards you can run the service using the following command:

`docker run -d -p 8080:8080 --name case-eventservice --network=case case-eventservice`

The standard config is build to run within the docker context so it shouldn't be necessary to change it.
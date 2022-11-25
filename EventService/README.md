# Event Service

This API is used to save events and search for them. 

## Deployment

### Native Deployment
#### Prerequisits 
The machine running this API needs to have at least a JRE installed. A guide to install Java can be found [here](https://docs.oracle.com/goldengate/1212/gg-winux/GDRAD/java.htm#BGBFJHAB)

O

To persist data using this API a running MongoDB is needed. To install the MongoDB you can use a docker container or use the native installation guide [here](https://www.mongodb.com/docs/manual/installation/).

After that you can run the application using the command `maven run shtin sthin`


### Relevant Articles:

- [Clean Architecture with Spring Boot](https://www.baeldung.com/spring-boot-clean-architecture)



export M2_HOME="/Library/Java/mvn/apache-maven-3.8.6"
PATH="${M2_HOME}/bin:${PATH}"
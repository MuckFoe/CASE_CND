# Base Image
FROM eclipse-temurin:18

# Labels as key value pair
LABEL Maintainer="moritz.zeitler"


# Chose the workin directory
WORKDIR /usr/caseeventservice/src

# Copy the jar file  
COPY ./target/EventService-1.0.jar ./EventService-1.0.jar

# Copy the spring config file
COPY ./src/main/resources/application.yml ./config/

# Start Java Application and provide path to config files
CMD ["java","-jar","EventService-1.0.jar", "--spring.config.name=application",  "--spring.config.location=/usr/caseeventservice/src/config/"]
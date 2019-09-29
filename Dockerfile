# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="d.c.budris@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/governetcore-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD target/${JAR_FILE} governetcore.jar

CMD mkdir data

# Add the datafiles from the local machine
ADD data data

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/governetcore.jar"]
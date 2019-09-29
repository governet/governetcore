# Clone the source of the application
FROM alpine/git as clone
LABEL maintainer="d.c.budris@gmail.com"
WORKDIR /app
RUN git clone https://github.com/governet/governetcore.git

# Build the application with Maven
FROM maven:3.5-jdk-8-alpine as build
LABEL maintainer="d.c.budris@gmail.com"
WORKDIR /app
COPY --from=clone /app/governetcore /app
RUN mvn install

# Run the application server
FROM openjdk:8-jdk-alpine
LABEL maintainer="d.c.budris@gmail.com"
WORKDIR /app
COPY --from=build /app/target/governetcore-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/governetcore-0.0.1-SNAPSHOT.jar"]
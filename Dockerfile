# Clone the source of the application
FROM alpine/git as clone
LABEL maintainer="d.c.budris@gmail.com"
WORKDIR /app
COPY . .

# Build the application with Maven
FROM maven:3.5-jdk-8-alpine as build
LABEL maintainer="d.c.budris@gmail.com"
WORKDIR /app
COPY --from=clone /app /app
RUN ln -s /app/data /data
RUN mvn install

# Run the application server
FROM openjdk:8-jdk-alpine
EXPOSE 8080

LABEL maintainer="d.c.budris@gmail.com"

WORKDIR /data
COPY --from=build /app/data .

WORKDIR /app
COPY --from=build /app/target/governetcore-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/governetcore-0.0.1-SNAPSHOT.jar"]

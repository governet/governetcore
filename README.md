# GovernetCore
The core of the governet API. 

Provides a spring-boot application which serves election information extracted from Federal Election Commission data sets.

Provides a library to map FEC data sets to java objects and load them into application memory.

## Running governetcore API
`docker pull danbudris/governetcore && docker run -p 8080:8080 danbudris/governetcore`

## Getting started with development
- Clone the repo
`git clone https://github.com/governet/governetcore.git`

- Build with Docker
`docker build . -t governetcore:example`

- Run the app
`docker run -p 8080:8080 governetcore:example`

- Check out the data
`curl 127.0.0.1:8080/candidates/

## Ref
[Docker Hub](https://hub.docker.com/r/danbudris/governetcore)

[Github](https://github.com/governet/governetcore)

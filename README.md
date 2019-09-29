# GovernetCore
The core of the governet API.

## Running governetcore API
Check out [Docker Hub](https://hub.docker.com/r/danbudris/governetcore) if you just want to run the app.

## Getting started with the app
- Clone the repo
`git clone https://github.com/governet/governetcore.git`

- Build with Docker
`docker build . -t governetcore:example`

- Run the app
`docker run -p 8080:8080 governetcore:example`

- Check out the data
`curl 127.0.0.1:8080/candidates/

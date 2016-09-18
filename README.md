# docker
A collection of docker related stuff

# build docker image
docker build -t clj-devbox -f Dockerfile.clj .

# run
docker run -d -t --name devbox1 clj-devbox /bin/bash

# attach
docker exec -i -t devbox1 /bin/bash

# run docker with mongodb
docker run -d -t -p {local port}:27017 -v {local folder}:/opt --name {container-name} mongo mongod



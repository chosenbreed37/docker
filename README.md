# docker
A collection of docker related stuff

# build docker image
docker build -t clj-devbox -f Dockerfile.clj .

# run
docker run -d -t --name devbox1 clj-devbox /bin/bash

# attach
docker exec -i -t devbox1 /bin/bash


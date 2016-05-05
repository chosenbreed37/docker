FROM ubuntu:trusty

MAINTAINER chosenbreed37 <chosenbreed@gmail.com>

# update packages
RUN apt-get update

# install vim
RUN apt-get install -y --force-yes vim

# install tree
RUN apt-get install -y --force-yes tree

# install git
RUN apt-get install -y --force-yes git

# install curl
RUN apt-get install -y --force-yes curl

# install nodejs
RUN curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -
RUN apt-get install -y --force-yes  nodejs

# install elm
RUN npm install -g -y --force-yes elm

# set up working directory
RUN mkdir /git
WORKDIR /git

# run the elm repl
elm-repl


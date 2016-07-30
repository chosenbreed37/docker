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

# fix SSL
RUN apt-get update
RUN apt-get install -y --force-yes libssl1.0.0 libssl-dev
RUN cd /lib/x86_64-linux-gnu
RUN ln -s libssl.so.1.0.0 libssl.so.10
RUN ln -s libcrypto.so.1.0.0 libcrypto.so.10

# install elm
RUN npm install -g -y --force-yes elm

# set up working directory
RUN mkdir /git
WORKDIR /git

# expose port 8000
EXPOSE 8000

CMD [ "--address=0.0.0.0" ] 




FROM pandeiro/oracle-jdk8
MAINTAINER chosenbreed <chosenbreed@gmail.com>

ENV LEIN_ROOT true

RUN wget -q -O /usr/bin/lein \
    https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein \
        && chmod +x /usr/bin/lein

# update packages
RUN apt-get update

# install vim
RUN apt-get install -y vim

# install tree
RUN apt-get install -y tree

# install git
RUN apt-get install -y git

# run lein once
RUN lein --help

RUN mkdir /git
WORKDIR /git

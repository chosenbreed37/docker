FROM pandeiro/oracle-jdk8
MAINTAINER chosenbreed <chosenbreed@gmail.com>

ENV LEIN_ROOT true

RUN wget -q -O /usr/bin/lein \
    https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein \
        && chmod +x /usr/bin/lein

# update packages
RUN apt-get update

# install vim
RUN apt-get install -y --force-yes vim

# install tree
RUN apt-get install -y --force-yes tree

# install git
RUN apt-get install -y --force-yes git

# run lein once
RUN lein --help

RUN mkdir /git
WORKDIR /git

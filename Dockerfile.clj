FROM pandeiro/oracle-jdk8
MAINTAINER chosenbreed <chosenbreed@gmail.com>

ENV LEIN_ROOT true

RUN wget -q -O /usr/bin/lein \
    https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein \
        && chmod +x /usr/bin/lein

#install vim
RUN apt-get -y install vim

RUN lein

RUN mkdir /src
WORKDIR /src

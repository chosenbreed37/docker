FROM java:8-jdk

MAINTAINER chosenbreed37 <chosenbreed@gmail.com>

ENV SCALA_HOME /usr/local/share/scala
ENV PATH $PATH:$SCALA_HOME/bin

ENV SCALA_VERSION 2.12.1
RUN wget --quiet http://downloads.lightbend.com/scala/$SCALA_VERSION/scala-$SCALA_VERSION.tgz && \
    tar -xf scala-$SCALA_VERSION.tgz && \
    rm scala-$SCALA_VERSION.tgz && \
    mv scala-$SCALA_VERSION $SCALA_HOME

ENV SBT_VERSION 0.13.13
RUN apt-get update -y && \
    apt-get install -y --no-install-recommends apt-transport-https && \
    apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 642AC823 && \
    echo "deb https://dl.bintray.com/sbt/debian /" > /etc/apt/sources.list.d/sbt.list && \
    apt-get update -y && apt-get install -y --no-install-recommends "sbt=$SBT_VERSION" && \
    sbt exit && \
    rm /etc/apt/sources.list.d/sbt.list && \
    apt-get purge -y apt-transport-https && \
    apt-get clean -y && \
    rm -rf /var/lib/apt/lists/*







From openjdk:alpine
MAINTAINER Dinesh Bhattarai <dineshbhattrai0@gmail.com>
WORKDIR /
COPY build/libs/auction-0.0.1-SNAPSHOT.jar .
CMD java -jar auction-0.0.1-SNAPSHOT.jar

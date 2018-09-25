FROM openjdk:8-alpine
ARG VERSION=1.0-SNAPSHOT
RUN echo "PWD is: $ls"
ADD sender-${VERSION}.jar /sender.jar
CMD java -jar /sender.jar

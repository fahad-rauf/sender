FROM openjdk:8-alpine
ARG VERSION=0.1.0
ADD sender-${VERSION}.jar /sender.jar
CMD java -jar /sender.jar

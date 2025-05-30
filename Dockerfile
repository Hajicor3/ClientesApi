FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:21-jdk-slim
EXPOSE 8081

RUN mkdir /newrelic

COPY --from=build ./src/main/resources/newrelic/newrelic.jar /newrelic/newrelic.jar
COPY --from=build ./src/main/resources/newrelic/newrelic.yml ./newrelic/newrelic.yml

COPY --from=build ./target/clientesApi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-javaagent:/newrelic/newrelic.jar","-jar", "app.jar"]
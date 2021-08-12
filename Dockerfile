FROM openjdk:12-alpine

WORKDIR /app

COPY target/test-0.0.1-SNAPSHOT.jar app.jar

ENV APIKEY=RGAPI-99f7f915-eaf4-4ed0-b2b7-e4c7d3b5bc9d
ENV DB_USERNAME=leagueadmin
ENV DB_PASSWORD=password
ENV DB_URL=jdbc:postgresql://leaguedb.ctmlv21ktrhx.eu-central-1.rds.amazonaws.com:5432/leaguedb
ENV PROFILE=production

ENTRYPOINT [ "java" , "-jar" , "app.jar" ]
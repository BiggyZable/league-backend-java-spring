FROM openjdk:12-alpine

WORKDIR /app

COPY target/test-0.0.1-SNAPSHOT.jar app.jar

ENV APIKEY=RGAPI-1c1361d8-c538-45b9-ace8-d9ff8decefe6
ENV DB_USERNAME=leagueadmin
ENV DB_PASSWORD=password
ENV DB_URL=jdbc:postgresql://league-db.ctmlv21ktrhx.eu-central-1.rds.amazonaws.com:5432/leaguedb
ENV PROFILE=production

ENTRYPOINT [ "java" , "-jar" , "app.jar" ]

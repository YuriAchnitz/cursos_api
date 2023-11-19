FROM openjdk:17-jdk-slim

WORKDIR /cursos_api
COPY target/*.jar /cursos_api/cursos_api-0.0.1-SNAPSHOT.jar
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar cursos_api-0.0.1-SNAPSHOT.jar 

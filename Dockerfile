<<<<<<< HEAD
<<<<<<< HEAD
FROM openjdk:17-jre-slim
=======
FROM openjdk:8-jre-slim
>>>>>>> branch 'main' of https://github.com/YuriAchnitz/cursos_api.git
=======
FROM openjdk:17-alpine
>>>>>>> branch 'main' of https://github.com/YuriAchnitz/cursos_api.git
WORKDIR /cursos_api
COPY target/*.war /cursos_api/cursos_api-0.0.1-SNAPSHOT.war
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar cursos_api-0.0.1-SNAPSHOT.war 




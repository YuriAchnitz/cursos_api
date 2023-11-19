FROM sasnouskikh/livy:0.8.0-incubating-spark_3.0.1_2.12-hadoop_3.2.0_cloud

RUN apt-get update --allow-releaseinfo-change
RUN apt install curl -y

FROM openjdk:17-jdk-slim

WORKDIR /cursos_api
COPY target/*.jar /cursos_api/cursos_api-0.0.1-SNAPSHOT.jar
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar cursos_api-0.0.1-SNAPSHOT.jar 

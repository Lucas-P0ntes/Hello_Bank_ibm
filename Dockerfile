FROM openjdk:11-jdk
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
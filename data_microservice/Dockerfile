#use this for building image
FROM openjdk:11
EXPOSE 8086
ADD target/messages-0.0.1-SNAPSHOT.jar messages-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/messages-0.0.1-SNAPSHOT.jar"]

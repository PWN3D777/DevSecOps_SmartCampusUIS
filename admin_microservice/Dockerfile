FROM alpine

RUN apk add openjdk17

ADD target/admin-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java","-jar","/app.jar" ]

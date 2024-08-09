FROM amazoncorretto:21
USER root
WORKDIR /deployment/app

COPY tmp/target/again*.jar /deployment/app/again-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/deployment/app/again-0.0.1-SNAPSHOT.jar"]
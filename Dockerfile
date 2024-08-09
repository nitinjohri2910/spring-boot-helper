FROM amazoncorretto:21
USER root



RUN     yum -y update && \
    yum -y install wget && \
    yum install -y tar.x86_64 && \
    yum clean all

COPY . /tmp/app-build
WORKDIR /tmp/app-build

RUN ./mvnw clean install

WORKDIR /deployment/app

COPY tmp/app-build/again*.jar /deployment/app/again-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/deployment/app/again-0.0.1-SNAPSHOT.jar"]
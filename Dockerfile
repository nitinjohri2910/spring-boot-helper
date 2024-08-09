FROM amazoncorretto:21-alpine-jdk as build

USER root

COPY . /tmp/app-build
WORKDIR /tmp/app-build

RUN chmod +x mvnw
#RUN chown 0:root /tmp/app-build && \
RUN ./mvnw clean install

FROM amazoncorretto:21-alpine-jdk

RUN \
   mkdir -p /deployments/app && \
   chown 0:root -R /deployments && \
   chown -R 775 /deployments

WORKDIR /deployments/app

COPY --from=build tmp/app-build/target/again*.jar /deployments/app/again-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/deployments/app/again-0.0.1-SNAPSHOT.jar"]
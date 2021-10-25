FROM maven:3.8.3-jdk-11-slim as build

WORKDIR /build

COPY ./ ./

RUN mvn clean package

# ------------ #
FROM openjdk:11-jdk-slim

WORKDIR /app/prebid-server

VOLUME /app/prebid-server/conf
VOLUME /app/prebid-server/data

COPY src/main/docker/run.sh ./
COPY src/main/docker/application.yaml ./
COPY --from=build /build/target/prebid-server.jar ./

EXPOSE 8080
EXPOSE 8060

ENTRYPOINT [ "/app/prebid-server/run.sh" ]

# Use Maven to build the project
FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Use the JAR files from the build step
FROM eclipse-temurin:11
LABEL maintainer="tien.huynhlt.tn@gmail.com"

WORKDIR /app

COPY --from=build /app/Wikimedia-data-consumer/target/Wikimedia-data-consumer-0.0.1.jar /app/Wikimedia-data-consumer.jar
COPY --from=build /app/Wikimedia-data-producer/target/Wikimedia-data-producer-0.0.1.jar /app/Wikimedia-data-producer.jar
COPY --from=build /app/start-services.sh /app/start-services.sh

RUN chmod +x /app/start-services.sh

ENTRYPOINT ["/app/start-services.sh"]

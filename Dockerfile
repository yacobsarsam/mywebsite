FROM gradle:jdk20

COPY ./ ./

RUN gradle build

FROM amazoncorretto:21-alpine

RUN mv ./build/libs/MyWebsite-0.0.1-SNAPSHOT-plain.jar /app.jar

EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]

FROM gradle:jdk21 as builder

COPY ./ ./

RUN gradle build

RUN mv ./build/libs/MyWebsite-0.0.1-SNAPSHOT-plain.jar /app.jar

FROM amazoncorretto:21-alpine

COPY --from=builder /app.jar /app.jar

EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]
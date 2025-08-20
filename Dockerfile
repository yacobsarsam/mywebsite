FROM gradle:jdk21 AS builder

WORKDIR /app
COPY ./ ./

RUN gradle build --no-daemon --stacktrace --info

RUN mv ./build/libs/MyWebsite-0.0.1-SNAPSHOT.jar /app.jar

FROM amazoncorretto:21-alpine

COPY --from=builder /app.jar /app.jar

EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]
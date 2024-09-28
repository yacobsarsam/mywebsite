FROM gradle:jdk20

COPY ./ ./

RUN gradle build


COPY --from=builder /app.jar /app.jar

EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]

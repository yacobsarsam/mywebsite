# ---- Build stage ----
FROM gradle:jdk21 AS builder
WORKDIR /home/gradle/project

# Copy wrapper + build scripts first (for better caching)
COPY gradlew ./
COPY gradle gradle
COPY build.gradle settings.gradle ./
RUN chmod +x ./gradlew
RUN ./gradlew dependencies --no-daemon || true

# Copy the rest of the project
COPY . .

# Build the app with your wrapper (skip tests for faster build if desired)
RUN ./gradlew build -x test --no-daemon

# ---- Runtime stage ----
FROM amazoncorretto:21-alpine
WORKDIR /app

# Copy the built jar (wildcard avoids hardcoding version)
COPY --from=builder /home/gradle/project/build/libs/*SNAPSHOT*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

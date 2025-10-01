# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . /app
RUN ./mvnw package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/rehabilitationml-0.1.0.jar"]

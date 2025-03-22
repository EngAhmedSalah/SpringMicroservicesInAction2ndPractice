# Stage 1: Build the application
FROM maven:3.8.6-openjdk-17 AS builder

# Set working directory
WORKDIR /app

# Copy the entire project (assuming pom.xml is in project1/UserService/)
COPY . .

# Build the application, skipping tests (matches your pipeline)
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port your microservice runs on (default Spring Boot port is 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
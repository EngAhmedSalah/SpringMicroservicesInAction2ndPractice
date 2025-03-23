# Stage 1: Build the applications
FROM maven:3.8-openjdk-17 AS builder

WORKDIR /app

# Copy all service directories
COPY EurekaServer/ ./EurekaServer/
COPY configServer/ ./configServer/
COPY UserService/ ./UserService/

# Build each service
RUN cd EurekaServer && mvn clean package -DskipTests && \
    cd ../configServer && mvn clean package -DskipTests && \
    cd ../UserService && mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JARs from the builder stage
COPY --from=builder /app/EurekaServer/target/*.jar eureka-server.jar
COPY --from=builder /app/configServer/target/*.jar config-server.jar
COPY --from=builder /app/UserService/target/*.jar user-service.jar

# Expose ports for Eureka (8761), Config Server (8888), and UserService (8081)
EXPOSE 8761 8888 8081

# Run all services in the same container
ENTRYPOINT ["sh", "-c", "java -jar eureka-server.jar & java -jar config-server.jar & java -jar user-service.jar"]
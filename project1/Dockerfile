# Stage 1: Build the applications
FROM openjdk:17

# Copy all service directories
COPY EurekaServer/ ./EurekaServer/
COPY configServer/ ./configServer/
COPY UserService/ ./UserService/

# Build each service
RUN cd EurekaServer && mvn clean package -DskipTests
RUN cd configServer && mvn clean package -DskipTests
RUN cd UserService && mvn clean package -DskipTests

# Copy the JARs from each service
COPY  project1/configServer/target/*.jar eureka-server.jar
COPY project1/configServer/target/*.jar config-server.jar
COPY project1/UserService/target/*.jar user-service.jar

# Expose ports for Eureka (8761), Config Server (8888), and UserService (8081)
EXPOSE 8761 8888 8081

# Run all services in the same container (using & to run in background)
ENTRYPOINT ["sh", "-c", "java -jar eureka-server.jar & java -jar config-server.jar & java -jar user-service.jar"]
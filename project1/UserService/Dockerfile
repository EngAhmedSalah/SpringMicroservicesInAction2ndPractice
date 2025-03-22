FROM openjdk:17
MAINTAINER spring microservices in action 2nd
COPY target/UserService-0.0.1-SNAPSHOT.jar UserService-0.0.1-SNAPSHOT.jar
ENV SPRING_PROFILES_ACTIVE=local
ENTRYPOINT ["java","-jar","/UserService-0.0.1-SNAPSHOT.jar"]
# Use a base image with Java and JRE
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/l7-fc-mockservices.jar l7-fc-mockservices.jar

# Expose the port that the Spring Boot application is listening on
EXPOSE 8011

# Set the command to run the Spring Boot application
CMD ["java", "-jar", "l7-fc-mockservices.jar"]

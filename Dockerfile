# Use the official Ubuntu base image
FROM ubuntu:latest

# Set the working directory in the container
WORKDIR /app

# Update package lists and install OpenJDK 17
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk

# Copy the entire project to the container
COPY . .

# Build the Spring Boot application using Gradle
RUN ./gradlew bootJar --no-daemon

# Use official OpenJDK 17 base image
FROM eclipse-temurin:17-jdk



# Copy the JAR file into the container
COPY target/runnerspace-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (default Spring Boot port is 8080)
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Build Stage (Maven)
FROM maven:3.8.7-eclipse-temurin-17 AS build

# Set the working directory where the pom.xml is located
WORKDIR /usr/src/app

# Copy only the backend folder
COPY apps/backend /usr/src/app

# Compile the application
RUN mvn clean package -DskipTests

# Run Stage (JRE)
FROM eclipse-temurin:17-jre-alpine

# Set the working directory for the runtime
WORKDIR /app

# Copy the generated JAR from the build stage
COPY --from=build /usr/src/app/target/harness-java-backend-1.0-SNAPSHOT.jar /app/app.jar

# Expose the application port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
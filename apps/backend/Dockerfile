# Build Stage (Maven)
FROM maven:3.8.7-eclipse-temurin-17 AS build

# Copy all content from the build context (apps/backend)
COPY . /usr/src/app

WORKDIR /usr/src/app

# Compile the application
RUN mvn clean package -DskipTests

# Run Stage (JRE)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the generated JAR
COPY --from=build /usr/src/app/target/harness-java-backend-1.0-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
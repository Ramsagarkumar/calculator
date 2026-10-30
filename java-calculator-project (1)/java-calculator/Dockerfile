# Build stage: compile and package the application
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY settings.xml /root/.m2/settings.xml
RUN mvn -B dependency:go-offline
COPY src ./src
RUN mvn -B clean package

# Runtime stage: only the JRE and application JAR
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/java-calculator-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
CMD ["10", "+", "5"]

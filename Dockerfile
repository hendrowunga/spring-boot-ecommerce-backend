# === Build Stage ===
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Optional: skip tests biar build lebih cepat
RUN mvn clean package -DskipTests

# === Run Stage ===
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app
EXPOSE 8080

# Copy jar dari build stage
COPY --from=build /app/target/*.jar app.jar

# Jalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]

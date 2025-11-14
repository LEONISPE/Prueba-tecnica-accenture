
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /build
COPY ../.. .
RUN mvn -B -ntp clean package -DskipTests -pl Subasta-puja/Subasta-puja -am


FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /build/prueba-tecnica-accenture/prueba-tecnica-accenture/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

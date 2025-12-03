# Use official Quarkus JVM image
FROM quay.io/quarkus/quarkus-micro-image:2.0

# Set working directory
WORKDIR /app

# Copy build output (Gradle or Maven)
COPY build/quarkus-app/lib/ /app/lib/
COPY build/quarkus-app/app/ /app/app/
COPY build/quarkus-app/quarkus/ /app/quarkus/
COPY build/quarkus-app/quarkus-run.jar /app/quarkus-run.jar

# Expose Quarkus default port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/quarkus-run.jar"]

# Build

FROM openjdk:17-alpine as builder
ADD . /builder
WORKDIR /builder
RUN ./gradlew build

# Run

FROM openjdk:17-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/shoot-0.0.1.jar /app/shoot-0.0.1.jar
CMD ["java", "-jar", "shoot-0.0.1.jar" ]
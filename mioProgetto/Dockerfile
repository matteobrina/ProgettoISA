FROM maven:3.9.0-eclipse-temurin-17

WORKDIR home/isa

COPY pom.xml .
COPY src src/

RUN apt update && apt install -y libxtst6 libxrender1 libxi6
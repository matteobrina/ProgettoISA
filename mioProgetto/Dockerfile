FROM ubuntu:22.04

WORKDIR home/isa

COPY pom.xml .
COPY src src/

RUN apt update && apt upgrade && apt install -y openjdk-17-jdk openjdk-17-jre && apt install -y maven && apt install -y libxtst6 libxrender1 libxi6 && apt install -y rhythmbox


# Java Calculator - Maven, Docker and Jenkins

A small Java 21 command-line calculator with Maven/JUnit tests, a multi-stage Docker build, and a Jenkins pipeline.

## Prerequisites

- Java 21 and Maven (for local builds)
- Docker Engine
- Jenkins with Pipeline, JUnit and a Docker-capable agent (for CI)

## Run locally

```bash
mvn -s settings.xml clean test package
java -jar target/java-calculator-1.0.0.jar 10 + 5
java -jar target/java-calculator-1.0.0.jar 10 / 2
```

Supported operators: `+`, `-`, `*`, `/`.

## Build and run with Docker

```bash
docker build -t java-calculator:latest .
docker run --rm java-calculator:latest 10 + 5
docker run --rm java-calculator:latest 20 '*' 4
docker run --rm java-calculator:latest 10 / 0
```

The default container command is `10 + 5` if no arguments are supplied.

## Jenkins

Create a Pipeline job pointing to this repository and use `Jenkinsfile` as the pipeline script.
The Jenkins agent must have Maven (or `mvn`) and Docker CLI/daemon access. The pipeline runs Maven tests,
builds the Docker image, and performs a container smoke test.

## Maven settings

`settings.xml` uses Maven Central defaults and the standard local repository. If your company uses a
private artifact repository, configure its mirror and credentials securely in Jenkins rather than
committing passwords to source control.

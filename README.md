# Loans-service

This repository contains the source code for a Spring Boot application called `Loans-service`. This service is part of the Fintech-LSI project and likely handles loan-related functionalities.

## Project Structure

The repository is organized as follows:

- **`.mvn/wrapper`**: Contains the Maven Wrapper files, allowing the project to be built without requiring Maven to be installed globally.
- **`k8s`**: Contains Kubernetes configuration files for deploying the application.
- **`src`**: Contains the main source code for the Spring Boot application.
- **`.gitattributes`**: Specifies how Git should handle line endings and other file attributes.
- **`.gitignore`**: Specifies intentionally untracked files that Git should ignore.
- **`Dockerfile`**: Defines how to build a Docker image for the application.
- **`Jenkinsfile`**: Defines the pipeline for building, testing, and deploying the application using Jenkins.
- **`mvnw`**: The Maven Wrapper executable for Unix-like systems.
- **`mvnw.cmd`**: The Maven Wrapper executable for Windows systems.
- **`pom.xml`**: Defines the project configuration and dependencies for Maven.
- **`README.md`**: This file, providing information about the repository.

## Technology Stack

- **Java**: The primary programming language used for the application.
- **Spring Boot**: The framework used for building the application.
- **Maven**: The build tool used for managing dependencies and building the project.
- **Docker**: Used for packaging the application into a container.
- **Kubernetes**: Used for deploying and managing the application in a cluster.
- **Jenkins**: Used for CI/CD automation.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven
- Docker (if you want to build and run the application in a container)
- Kubernetes cluster (if you want to deploy the application to Kubernetes)
- Jenkins (if you want to use the automated deployment pipeline)

### Building the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/Fintech-LSI/Loans-service.git
   cd Loans-service
   ```

2. Build the application using Maven Wrapper:

   ```bash
   ./mvnw clean install
   ```

### Running the Application

1. Run the application using Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

2.  Alternatively, you can build a docker image

   ```bash
   docker build -t loans-service .
   ```
3. Run it
   ```bash
   docker run -p 8080:8080 loans-service
   ```
   The application should now be accessible at `http://localhost:8080` (or the specified port in the properties).


### Deployment

- **Kubernetes**: The `k8s` directory contains the necessary Kubernetes manifests for deploying the application to a Kubernetes cluster.
- **Jenkins**: The `Jenkinsfile` provides a Jenkins pipeline for continuous integration and continuous deployment (CI/CD).

## Contributing

If you want to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your changes.
3. Make your changes and commit them.
4. Push your branch to your forked repository.
5. Create a pull request to the main repository.

# Wikimedia Data Processing

## Table of Contents
- [Description](#description)
- [Technologies Used](#technologies-used)
- [Architecture Overview](#architecture-overview)
- [Setup and Run Instructions](#setup-and-run-instructions)
  - [Using IntelliJ](#using-intellij)
  - [Using Docker Compose](#using-docker-compose)
- [Monitoring and Logs](#monitoring-and-logs)
- [References](#references)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

## Description

The **Wikimedia Data Processing** project is designed to handle and process large volumes of real-time streaming data from Wikimedia. The project leverages Kafka for efficient and scalable data ingestion and processing and utilizes MySQL for data storage, enabling analytical insights.

### Key Features
- **Real-Time Data Ingestion**: Utilizes a Kafka producer to stream real-time data from Wikimedia.
- **Data Processing**: Consumes and processes real-time data via a Kafka consumer.
- **Data Storage**: Persists processed data into a MySQL database.
- **Scalability**: Built with Spring Boot microservices architecture for scalability and maintainability.

For accessing the real-time stream data from Wikimedia, visit: [Wikimedia Stream](https://stream.wikimedia.org/v2/stream/recentchange)

## Technologies Used

### Backend
- **Java**: Version 11
- **Spring Boot**: Version 2.5.12
- **Apache Kafka**: Distributed streaming platform
- **Apache Maven**: Version 3.8.4 for build automation

### Database
- **MySQL**: Relational Database Management System

### Tools
- **Docker**: Version 27.0.3 for containerization
- **IntelliJ IDEA**: 2024.1.4 (Community Edition)
- **Docker Desktop**: Version 4.31.1

## Architecture Overview

The project follows a microservices architecture and comprises two main components:

1. **Wikimedia Data Producer**: A Kafka producer that reads real-time data from Wikimedia and publishes it to a Kafka topic.
2. **Wikimedia Data Consumer**: A Kafka consumer that reads data from the Kafka topic and stores it in a MySQL database.

## Setup and Run Instructions

### Using IntelliJ

#### Prerequisites
- Install **Docker** and **Docker Compose**
- Install **Java 11**
- Install **Maven 3.8.4**

#### Step-by-Step Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/tienhuynh-tn/Wikimedia-data-processing.git
   cd Wikimedia-data-processing
   ```

2. **Build the Project**:
   ```bash
   mvn clean install
   ```

3. **Run Docker Services**:
   - Start Kafka UI:
     ```bash
     docker compose -f ./docker/kafka-ui.yml up -d
     ```
   - Start MySQL Database:
     ```bash
     docker compose -f ./docker/mysql.yml up -d
     ```

4. **Run Services in IntelliJ**:
   - Open IntelliJ, import the project, and run the main classes for both producer and consumer modules.

### Using Docker Compose

1. **Edit `application.yml` Configuration**:
   - Update the configuration to match the Docker environment (comment/uncomment as necessary).

2. **Navigate to the Docker Directory**:
   ```bash
   cd ./docker/
   ```

3. **Build Docker Images**:
   ```bash
   docker-compose build --no-cache
   ```

4. **Start All Services**:
   ```bash
   docker-compose up -d
   ```

5. **View Application Logs**:
   ```bash
   docker logs -f wikimedia-data-processing
   ```

## Monitoring and Logs

- **Kafka UI**: Access Kafka UI at `http://localhost:8080` to monitor Kafka topics and messages.
- **Application Logs**: Use `docker logs -f <container_name>` to view real-time logs for each service.

## References

- Course: [Building Microservices with Spring Boot & Spring Cloud](https://www.udemy.com/course/building-microservices-with-spring-boot-and-spring-cloud/) by [Ramesh Fadatare (Java Guides)](https://www.udemy.com/user/ramesh-fadatare/)

## Troubleshooting

- **Kafka Broker Not Starting**: Ensure the `zookeeper` service is running before starting the Kafka broker.
- **Connection Refused to MySQL**: Check the MySQL host and port configurations, and verify Docker network settings.
- **Kafka Connection Issues**: When running with Docker Compose, you may encounter `Connection to node -1 (localhost/127.0.0.1:9092) could not be established` errors initially. This is expected; the project should stabilize after a few minutes.

## Contributing

Contributions are welcome! Please submit a pull request or open an issue to get started.

## License

&copy; 2024 tienhuynh-tn. This project is licensed under the [MIT License](https://github.com/tienhuynh-tn/Wikimedia-data-processing/blob/main/LICENSE).

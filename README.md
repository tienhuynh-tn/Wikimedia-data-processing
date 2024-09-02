# Wikimedia Data Processing

## Table of Contents
- [Description](#description)
- [Technology](#technology)
- [Architecture Overview](#architecture-overview)
- [How to Set Up and Run by IntelliJ](#how-to-set-up-and-run-by-intellij)
- [How to Run with docker compose](#how-to-run-with-docker-compose)
- [Monitoring and Logs](#monitoring-and-logs)
- [References](#references)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License & Copyright](#license--copyright)

## Description

The **Wikimedia Data Processing** project focuses on processing a large volume of real-time streaming data from Wikimedia and storing it in a database for analytical purposes. The project utilizes Kafka for efficient and scalable data ingestion and processing.

### Key Features
- **Real-Time Data Ingestion**: Streams real-time data from Wikimedia using Kafka producer.
- **Data Processing**: Consumes the real-time data from Kafka and processes it using Kafka consumer.
- **Storage**: Stores processed data into a MySQL database.
- **Scalability**: Built on a microservices architecture using Spring Boot, making it scalable and easy to maintain.

The real-time stream data from Wikimedia can be accessed via this link: [https://stream.wikimedia.org/v2/stream/recentchange](https://stream.wikimedia.org/v2/stream/recentchange)

## Technology

### 1. Backend
- **Java Language** | Version: 11
- **Spring Boot Framework** | Version: 2.5.12
- **Kafka** | Distributed streaming platform
- **Docker** | Version: 27.0.3 (for containerization)
- **Apache Maven** | Version: 3.8.4 (build automation tool)

### 2. Database
- **MySQL** | Relational Database Management System

### 3. Tools
- **IntelliJ IDEA** | 2024.1.4 (Community Edition)
- **Docker Desktop** | 4.31.1

## Architecture Overview

The project follows a microservices architecture and includes two main components:

1. **Wikimedia Data Producer**: A Kafka producer that reads real-time data from Wikimedia and writes it to a Kafka topic.
2. **Wikimedia Data Consumer**: A Kafka consumer that reads data from the Kafka topic and writes it to a MySQL database.

## How to Set Up and Run by IntelliJ

### Prerequisites
Ensure that the following are installed on your system:
- **Docker** and **Docker Compose**
- **Java 11**
- **Maven 3.8.4**

### Step-by-Step Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/tienhuynh-tn/Wikimedia-data-processing.git
   cd Wikimedia-data-processing
   ```

2. **Build the Project**:
   ```bash
   mvn clean install

3. **Run Docker Services**:
- Start Kafka UI:
    ```bash
    docker compose -f .\docker\kafka-ui.yml up -d

- Start MySQL Database:
    ```bash
    docker compose -f .\docker\mysql.yml up -d

4. **Start projects by IntelliJ**:

## How to Run with docker compose

1. **Navigate to the Docker Directory**:
   ```bash
   cd .\docker\
   ```

2. **Build Docker Images without Cache**:
   ```bash
   docker-compose build --no-cache
   ```

3. **Start All Services**:
   ```bash
   docker-compose up -d
   ```

4. **View Logs for the Application**:
   ```bash
   docker logs -f wikimedia-data-processing
   ```

## Monitoring and Logs

- **Kafka UI**: Visit `http://localhost:8080` to monitor Kafka topics and messages.
- **Application Logs**: Logs are streamed in real-time using the `docker logs -f` command.

## References

- Course: [[NEW] Building Microservices with Spring Boot & Spring Cloud](https://www.udemy.com/course/building-microservices-with-spring-boot-and-spring-cloud/)
- Lecturer: [Ramesh Fadatare (Java Guides)](https://www.udemy.com/user/ramesh-fadatare/)

## Troubleshooting

- **Issue: Kafka Broker Not Starting**: Ensure that `zookeeper` service is up and running before starting the Kafka broker.
- **Issue: Connection Refused to MySQL**: Verify that MySQL is accessible at the configured host and port, and that network settings are correctly defined in Docker Compose.

## Contributing

Contributions are welcome! Please submit a pull request or open an issue to get started. Make sure to follow the [code of conduct](https://github.com/tienhuynh-tn/Wikimedia-data-processing/blob/main/CODE_OF_CONDUCT.md) and [contribution guidelines](https://github.com/tienhuynh-tn/Wikimedia-data-processing/blob/main/CONTRIBUTING.md).

## License & Copyright

&copy; 2024 tienhuynh-tn. Licensed under the [MIT LICENSE](https://github.com/tienhuynh-tn/Wikimedia-data-processing/blob/main/LICENSE).


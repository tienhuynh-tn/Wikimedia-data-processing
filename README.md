# Wikimedia Data Processing

## Table of Contents
- [Description](#description)
- [Technology](#technology)
- [How to set up?](#how-to-set-up)
- [How to run?](#how-to-run)
- [References](#references)
- [License & Copyright](#license--copyright)

## Description
- We're going to read a huge amount of real-time stream data from Wikimedia to the database. We will create a Kafka producer which will read real-time stream data from Wikimedia and then it will write that data to the Kafka broker. Hence, we create a Kafka consumer that will consume the real-time stream data from the Kafka broker and then it will write to the database.
- The real-time stream data from Wikimedia can be found through this link: [https://stream.wikimedia.org/v2/stream/recentchange](https://stream.wikimedia.org/v2/stream/recentchange)
- TBU

## Technology
**1. Backend**
- Java Language | version 11
- Spring Boot Framework | version 2.5.12
- Kafka
- Docker | version 27.0.3
- Apache Maven | version 3.8.4

**2. Database**
- MySQL

**3. Tools**
- IntelliJ IDEA 2024.1.4 (Community Edition)
- Docker Desktop 4.31.1

## How to set up?
### Run Docker:
- ``docker compose -f .\docker\kafka-ui.yml up -d``
- ``docker compose -f .\docker\mysql.yml up -d``
- TBU

## How to run?
- ``docker compose -f .\docker\docker-compose.yml up -d``
- ``docker logs -f wikimedia-data-processing``
- TBU

## References
- Course: [[NEW] Building Microservices with Spring Boot & Spring Cloud](https://www.udemy.com/course/building-microservices-with-spring-boot-and-spring-cloud/)
- Lecturer: [Ramesh Fadatare (Java Guides)](https://www.udemy.com/user/ramesh-fadatare/)

## License & Copyright
&copy; 2024 tienhuynh-tn Licensed under the [MIT LICENSE](https://github.com/tienhuynh-tn/Wikimedia-data-processing/blob/main/LICENSE).

#!/bin/sh

# Start the producer
java -jar Wikimedia-data-producer.jar &

# Optional: Wait for the producer to be ready. You can adjust the sleep duration as needed
sleep 10

# Start the consumer
java -jar Wikimedia-data-consumer.jar

package com.tienhuynh_tn.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.tienhuynh_tn.handler.WikimediaChangesHandler;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class WikimediaDataProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaDataProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    @Value("${wikimedia.stream-url}")
    private String wikimediaStreamUrl;

    public void sendMessage() {
        EventHandler backgroundEventHandler = new WikimediaChangesHandler(kafkaTemplate, topicName);

        // Create the event source builder with the Wikimedia stream URL
        EventSource.Builder builder = new EventSource.Builder(backgroundEventHandler, URI.create(wikimediaStreamUrl));

        // Build and start the event source
        EventSource eventSource = builder.build();
        eventSource.start();

        // Keep the event source running for a specific duration (optional)
        try {
            TimeUnit.MINUTES.sleep(10); // keep the connection open for 10 minutes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            eventSource.close();
        }
    }
}

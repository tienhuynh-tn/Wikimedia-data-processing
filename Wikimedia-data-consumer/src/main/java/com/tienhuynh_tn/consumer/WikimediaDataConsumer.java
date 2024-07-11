package com.tienhuynh_tn.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class WikimediaDataConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaDataConsumer.class);

    @KafkaListener(
            topics = "${kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeMessage(String eventMessage) {
        LOGGER.info(MessageFormat.format("Event message received -> {0}", eventMessage));
    }
}

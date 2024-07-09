package com.tienhuynh_tn.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WikimediaDataProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaDataProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
}

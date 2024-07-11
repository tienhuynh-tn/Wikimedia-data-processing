package com.tienhuynh_tn.consumer;

import com.tienhuynh_tn.entity.WikimediaData;
import com.tienhuynh_tn.repository.WikimediaDataRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class WikimediaDataConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaDataConsumer.class);

    private final WikimediaDataRepository wikimediaDataRepository;

    @KafkaListener(
            topics = "${kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeMessage(String eventMessage) {
        LOGGER.info(MessageFormat.format("Event message received -> {0}", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        wikimediaDataRepository.save(wikimediaData);
    }
}

package com.tienhuynh_tn;

import com.tienhuynh_tn.producer.WikimediaDataProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikimediaDataProducerApplication implements CommandLineRunner {

    @Autowired
    private WikimediaDataProducer wikimediaDataProducer;

    public static void main(String[] args) {
        SpringApplication.run(WikimediaDataProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        wikimediaDataProducer.sendMessage();
    }
}
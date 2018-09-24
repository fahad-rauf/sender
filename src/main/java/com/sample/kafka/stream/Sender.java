package com.sample.kafka.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    private final MessageChannel helloWorld;

    @Autowired
    public Sender(final MessageChannel helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void sendMessage(String message) {
        this.helloWorld.send(MessageBuilder.withPayload(message).build());
        LOGGER.info("Message sent: {}", message);

    }
}

package com.sample.kafka.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface HelloWorldChannelDefinition {

    @Output("helloWorld")
    SubscribableChannel helloWorld();
}

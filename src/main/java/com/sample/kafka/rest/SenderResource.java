package com.sample.kafka.rest;

import com.sample.kafka.stream.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sender")
public class SenderResource {
    private final Sender sender;

    @Autowired
    public SenderResource(final Sender sender) {
        this.sender = sender;
    }

    @PostMapping
    public ResponseEntity post(@RequestBody final String message) {
        try {
            sender.sendMessage(message);
        } catch (final Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
        return ResponseEntity.ok().build();
    }
}

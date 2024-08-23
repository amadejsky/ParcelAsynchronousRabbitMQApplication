package org.amadejsky.parcelpublisher.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    private final RabbitTemplate rabbitTemplate;

    public PublisherController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/message")
    private String sendMessage(@RequestParam String message){
        rabbitTemplate.convertAndSend("test",message);
        return "Message sent succesfully!";

    }
}

package org.amadejsky.parcelpublisher.controller;

import org.amadejsky.parcelpublisher.service.NotificationEmailService;
import org.amadejsky.parcelpublisher.service.NotificationEmailServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    private final RabbitTemplate rabbitTemplate;
    private final NotificationEmailServiceImpl notificationEmailService;

    public PublisherController(RabbitTemplate rabbitTemplate, NotificationEmailServiceImpl notificationEmailService) {
        this.rabbitTemplate = rabbitTemplate;
        this.notificationEmailService = notificationEmailService;
    }

    @GetMapping("/message")
    private String sendMessage(@RequestParam String message){
        rabbitTemplate.convertAndSend("test",message);
        return "Message sent succesfully!";

    }

    @GetMapping("/notification")
    private String sendNotification(@RequestParam Long parcelId){
        notificationEmailService.sendNotificationEmail(parcelId);
        return "Notification email about parcel has been sent!";
    }
}

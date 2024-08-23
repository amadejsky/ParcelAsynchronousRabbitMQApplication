package org.amadejsky.parcelreceiver.controller;

import org.amadejsky.parcelreceiver.model.NotificationEmail;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParcelReceiverController {

    private final RabbitTemplate rabbitTemplate;

    public ParcelReceiverController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

//    @RabbitListener(queues = "test")
//    public void listener(NotificationEmail notificationEmail){
//        System.out.println(
//                "Email: "+notificationEmail.getEmail()+"\n "+
//                "Title "+notificationEmail.getTitle()+"\n "+
//                "Content: "+notificationEmail.getContent()
//        );
//    }

    @RabbitListener(queues = "test")
    public void listenerMessage(String message){
        System.out.println("Received message is: "+message);
    }
}

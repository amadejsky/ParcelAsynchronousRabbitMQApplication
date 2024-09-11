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

    @RabbitListener(queues = "parcel_manager_event")
    public void listener(NotificationEmail notificationEmail){
        System.out.println(
                "Parcel with code: "+notificationEmail.getCode()+"\n "+
                "has been  "+notificationEmail.getInfo()+"\n "+
                "with delivery address: "+notificationEmail.getAddress()+"\n "+
                "and status: "+notificationEmail.getStatus()
        );
    }

//    @RabbitListener(queues = "test")
//    public void listenerMessage(String message){
//        System.out.println("Received message is: "+message);
//    }
}

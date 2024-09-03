package org.amadejsky.parcelpublisher.service;

import org.amadejsky.parcelpublisher.model.NotificationEmail;
import org.amadejsky.parcelpublisher.model.Parcel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class NotificationEmailServiceImpl implements NotificationEmailService{
    public static final String URL = "http://localhost:9000/parcels/";
    private final RestTemplate restTemplate;
    private final RabbitTemplate rabbitTemplate;

    public NotificationEmailServiceImpl(RestTemplate restTemplate, RabbitTemplate rabbitTemplate) {
        this.restTemplate = restTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendNotificationEmail(Long parcelId) {
        Parcel parcel = restTemplate.exchange(URL +parcelId,
                HttpMethod.GET, HttpEntity.EMPTY, Parcel.class).getBody();

        NotificationEmail notificationEmail = new NotificationEmail();
        notificationEmail.setEmail(parcel.getEmail());
        notificationEmail.setTitle("Hi dear customer!");
        notificationEmail.setContent("The package has been succesfully sent on:"+" "+parcel.getAddress()+"\n"+
        "And it weight is: "+parcel.getWeight());
        rabbitTemplate.convertAndSend("test",notificationEmail);
    }
}

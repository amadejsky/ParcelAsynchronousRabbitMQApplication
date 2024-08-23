package org.amadejsky.parcelpublisher;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ParcelPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcelPublisherApplication.class, args);
	}

	@Bean
	public MessageConverter massageConverter(){
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}

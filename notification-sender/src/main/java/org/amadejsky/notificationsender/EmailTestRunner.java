package org.amadejsky.notificationsender;

import org.amadejsky.notificationsender.service.SenderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailTestRunner implements CommandLineRunner {

    private final SenderService senderService;

    public EmailTestRunner(SenderService senderService) {
        this.senderService = senderService;
    }

    @Override
    public void run(String... args) throws Exception {

        senderService.sendSimpleMessage("madejsky567@gmail.com", "Test Email", "This is a test email from JavaMailSender.");

        System.out.println("Test email sent successfully!");
    }
}

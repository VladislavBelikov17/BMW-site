package com.mySite.MyJavaSite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServise {

    private final JavaMailSender mailSender;
    @Autowired
    public EmailServise(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /*----------------Отправка писем-------------*/

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("belikovvlad123@gmail.com");

        mailSender.send(message);
    }

    public void sendClientDataEmail(String to, String clientName, String clientData) {
        String subject = "Новые данные клиента";
        String text = String.format(
                "Здравствуйте!\n\n" +
                        "По Вашим данным был отправлен запрос на получение предложения:\n\n" +
                        "%s\n\n" + "\nСкоро с Вами свяжется наш специалист\n" +
                        "С уважением,\nBMW Motorrad Vladislav",
                clientData
        );

        sendSimpleMessage(to, subject, text);
    }
}

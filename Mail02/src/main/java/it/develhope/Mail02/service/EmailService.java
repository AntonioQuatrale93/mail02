package it.develhope.Mail02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;


    public void sendTo(String email, String title, String message) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
        if (message != null) {
            String htmlMsg = "<h1>Hello Student!</h1>" +
                    "<h2>You have a new message: </h2>" +
                    "<img src='https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png' alt='Alternative text' height='200'>" +
                    "<h3>" + message + "</h3>";

            messageHelper.setText(htmlMsg, true);
        }
        messageHelper.setTo(email);
        messageHelper.setSubject(title);
        messageHelper.setFrom("eserciziomail93@gmail.com");
        mailSender.send(mimeMessage);


    }
}

package com.newsapp.javamail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {
    public static void sendMail(String name, String email, String subject, String msg) {
        String host = "mail.daksumedia.com";
        final String user = "test@daksumedia.com";
        final String password = "your-password";
        String to = "krishnayamphu@gmail.com"; //admin email

        //#1: Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        //#2: Compose the message
        try {
            String data = name + " ," + email + "," + msg;
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(data);

            //#3: send the message
            Transport.send(message);
            System.out.println("message sent successfully...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

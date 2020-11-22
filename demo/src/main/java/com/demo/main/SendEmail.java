package com.demo.main;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public static void main(String [] args){
        String to = "icelol@abv.bg";
        String from = "motilove01@gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator()
        {

            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("motilove01@gmail.com","645312nikito0o2012");
            }
        });
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));
            message.setSubject("Test");
            message.setText("This is test mail!");
            Transport.send(message);
            System.out.println("Sent message successfully...");
        }
        catch (MessagingException mex){
            mex.printStackTrace();

        }
    }
}

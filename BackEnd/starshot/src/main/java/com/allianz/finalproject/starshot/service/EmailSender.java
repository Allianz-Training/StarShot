package com.allianz.finalproject.starshot.service;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {

  public EmailSender() {}

  public void sendMail(Integer integer, String email, String titleName, String firstName,
      String lastName) throws AddressException, MessagingException, IOException {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("starshot.contactus@gmail.com", "starshot007");
      }
    });


    String content = "<p>Dear " + titleName + ". " + firstName + " " + lastName + "," + "</p><br>"
        + "<p>Thank you for your purchase on our insurance</p></br>"
        + "<p>Your insurnce policy number: " + integer.toString() + "</p>";


    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress("starshot.contactus@gmail.com", false));
    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
    msg.setSubject("Confirmation Email");
    msg.setContent("Max email", "text/html");
    msg.setSentDate(new Date());
    MimeBodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setContent(content, "text/html");

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);


    msg.setContent(multipart);
    Transport.send(msg);

  }
}

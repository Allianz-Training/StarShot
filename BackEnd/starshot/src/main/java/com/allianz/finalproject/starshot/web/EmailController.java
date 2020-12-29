// package com.allianz.finalproject.starshot.web;
//
// import java.io.IOException;
// import java.util.Date;
// import java.util.Properties;
// import javax.mail.Message;
// import javax.mail.MessagingException;
// import javax.mail.Multipart;
// import javax.mail.PasswordAuthentication;
// import javax.mail.Session;
// import javax.mail.Transport;
// import javax.mail.internet.AddressException;
// import javax.mail.internet.InternetAddress;
// import javax.mail.internet.MimeBodyPart;
// import javax.mail.internet.MimeMessage;
// import javax.mail.internet.MimeMultipart;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.allianz.finalproject.starshot.bussiness.domain.InsuranceRegistration;
// import com.allianz.finalproject.starshot.bussiness.domain.InsuranceRepository;
//
//
// @RestController
// public class EmailController {
// @Autowired
// private InsuranceRepository insuranceRepository;
//
// @RequestMapping(value = "/confirmmail/{email}")
// public String sendEmail(@PathVariable String email) {
// try {
// sendMail(email);
// } catch (Exception e) {
// e.printStackTrace();
// }
// return "Email sent successfully";
//
//
// }
//
// private void sendMail(String email) throws AddressException, MessagingException, IOException {
// Properties props = new Properties();
// props.put("mail.smtp.auth", "true");
// props.put("mail.smtp.starttls.enable", "true");
// props.put("mail.smtp.host", "smtp.gmail.com");
// props.put("mail.smtp.port", "587");
// Session session = Session.getInstance(props, new javax.mail.Authenticator() {
// @Override
// protected PasswordAuthentication getPasswordAuthentication() {
// return new PasswordAuthentication("starshot.contactus@gmail.com", "starshot007");
// }
// });
//
//// InsuranceRegistration emailReciever = insuranceRepository.findByEmail(email);
// Message msg = new MimeMessage(session);
// msg.setFrom(new InternetAddress("starshot.contactus@gmail.com", false));
// msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
// msg.setSubject("Confirmation Email");
// msg.setContent("Max email", "text/html");
// msg.setSentDate(new Date());
// MimeBodyPart messageBodyPart = new MimeBodyPart();
// messageBodyPart.setContent("Dear", "text/html");
// messageBodyPart.setContent("Thank you for your purches our insurance", "text/html");
// Multipart multipart = new MimeMultipart();
// multipart.addBodyPart(messageBodyPart);
//
//
// // MimeBodyPart attachPart = new MimeBodyPart();
// // attachPart.attachFile("D:/blackhole.jpg");
// // multipart.addBodyPart(attachPart);
// msg.setContent(multipart);
// Transport.send(msg);
//
//
// }
//
//
// }
//

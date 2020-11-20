package com.ingesoft2.mail;

import java.io.IOException;

import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailPort {

  private JavaMailSender sender;

  public EmailService(JavaMailSender sender) {
    this.sender = sender;
  }

  @Override
  public boolean sendEmail(EmailBody emailBody) {
    return sendEmailTool(emailBody.getContent(), emailBody.getEmail(), emailBody.getSubject());
  }

  private boolean sendEmailTool(String textMessage, String email, String subject) {
    boolean send = false;
    MimeMessage message = sender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    MimeMultipart multipart = new MimeMultipart("related");
    try {

      MimeBodyPart textBody = new MimeBodyPart();
      textBody.setContent(textMessage, "text/html");
      multipart.addBodyPart(textBody);

      MimeBodyPart imageBody = new MimeBodyPart();

      java.io.InputStream inputStream = this.getClass().getResourceAsStream("../static/logo.png");
      ByteArrayDataSource ds = new ByteArrayDataSource(inputStream, "image/jpg");

      imageBody.setDataHandler(new DataHandler(ds));
      imageBody.setHeader("Content-ID", "<logo>");

      imageBody.setDisposition(MimeBodyPart.INLINE);

      multipart.addBodyPart(imageBody);


      helper.setTo(email);
      message.setContent(multipart);
      helper.setSubject(subject);
      sender.send(message);
      send = true;
    } catch (MessagingException e) {
      System.out.println("Error al enviar mail.");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return send;
  }
}

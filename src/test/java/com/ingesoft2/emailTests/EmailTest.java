package com.ingesoft2.emailTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ingesoft2.mail.EmailBody;
import com.ingesoft2.mail.EmailService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailTest {

  @Autowired
  private EmailService emailService;


  @Test
  public void sendEmail() {
    EmailBody myEmail = new EmailBody();
    myEmail.setEmail("csolanoc@unal.edu.co");
    myEmail.setContent("this is an email test");
    myEmail.setSubject("testing email feature");

    assertTrue(emailService.sendEmail(myEmail));
  }
}

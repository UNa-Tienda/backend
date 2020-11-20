package com.ingesoft2.emailTests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


import com.ingesoft2.mail.EmailBody;
import com.ingesoft2.mail.EmailService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailTest {

  @Autowired
  private EmailService emailService;

  @Test
  private void sendEmail() {
    EmailBody myEmail = new EmailBody();
    myEmail.setEmail("csolanoc@unal.edu.co");
    myEmail.setContent("<h3>this is an email test</h3> <img src=\"cid:logo\">");
    myEmail.setSubject("testing email feature");

    assertDoesNotThrow(() -> emailService.sendEmail(myEmail));
  }

  @Test
  private void sendEmailWithoutReceiver(){
    EmailBody myEmail = new EmailBody();
    myEmail.setContent("<h3>this is an email test</h3> <img src=\"cid:logo\">");
    myEmail.setSubject("testing email feature");

    assertThrows(IllegalArgumentException.class, () -> emailService.sendEmail(myEmail));
  }
}

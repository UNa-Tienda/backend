package com.ingesoft2.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/email"})
public class EmailController {

  @Autowired
  private EmailPort emailPort;

  @PostMapping(value = "/send")
  @ResponseBody
  public boolean sendEmail(@RequestBody EmailBody emailBody){
    return emailPort.sendEmail(emailBody);
  }
}

package com.SEII.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/rest/auth")
public class LoginController {
  @GetMapping("/login")
  public String loginPage(){
    return "login";
  }
}

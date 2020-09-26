package com.SEII.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NoAuthController {
  @GetMapping("/hi")
  public String sayHi(){
    return "hi";
  }
}

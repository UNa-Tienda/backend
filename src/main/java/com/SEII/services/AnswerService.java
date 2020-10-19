package com.SEII.services;

import java.util.List;

import com.SEII.models.Answer;
import com.SEII.repositories.AnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
  
  @Autowired
  AnswerRepository answerRepository;

  public List<Answer> getAnswers(){
    return answerRepository.findAll();
  }
}

package com.SEII.services;

import java.util.List;

import com.SEII.models.Answer;
import com.SEII.repositories.AnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
  
  private final AnswerRepository answerRepository;

  public AnswerService(AnswerRepository answerRepository){
    this.answerRepository = answerRepository;
  }

  public List<Answer> getAnswers(){
    return answerRepository.findAll();
  }
}

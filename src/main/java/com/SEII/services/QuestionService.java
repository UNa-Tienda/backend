package com.SEII.services;

import java.util.List;

import com.SEII.models.Question;
import com.SEII.repositories.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
  
  @Autowired
  QuestionRepository questionRepository;

  public List<Question> getQuestions(){
    return questionRepository.findAll();
  }
}

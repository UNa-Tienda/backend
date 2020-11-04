package com.SEII.services;

import java.util.List;

import com.SEII.models.Review;
import com.SEII.repositories.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
  
  private final ReviewRepository reviewRepository;


  public ReviewService(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }


  public List<Review> getReviews(){
    return reviewRepository.findAll();
  }
}

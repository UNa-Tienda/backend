package com.SEII.services;

import java.util.List;

import com.SEII.models.Coupon;
import com.SEII.repositories.CouponRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
  
  @Autowired
  CouponRepository couponRepository;

  public List<Coupon> getCoupons(){
    return couponRepository.findAll();
  }
}
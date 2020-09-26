package com.SEII.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .withUser("admin")
      .password("admin")
      .roles("ADMIN");
  }

  // security for all API

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
  }

  // security for URLS

  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  //   http.csrf().disable();
  //   http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().httpBasic();
  // }

  @Bean
  public NoOpPasswordEncoder passwordEncoder(){
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
  }
}

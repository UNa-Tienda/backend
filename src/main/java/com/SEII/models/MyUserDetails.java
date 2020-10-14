package com.SEII.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{

	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	// private SimpleGrantedAuthority authorities;


  public MyUserDetails(Person person){
		this.username = person.username;
		this.password = person.password;
		this.active = true;
		this.authorities = Arrays.stream(person.getRoles().split(","))
														 .map(SimpleGrantedAuthority::new)
														 .collect(Collectors.toList());
		// this.authorities = new SimpleGrantedAuthority("ROLE_USER");
  }

  @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
    return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}

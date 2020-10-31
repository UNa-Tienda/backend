package com.SEII.auth.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.SEII.models.PersonDTO;
import com.SEII.models.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public MyUserDetails(PersonDTO person) {
		this.username = person.getUsername();
		this.password = person.getPassword();
		this.authorities = translateRoles(person.getRole_id());
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
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	private Collection<? extends GrantedAuthority> translateRoles(Role role) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		String roleName = "ROLE_" + role.getName().toUpperCase();
		grantedAuthorities.add(new SimpleGrantedAuthority(roleName));
		return grantedAuthorities;
	}
}

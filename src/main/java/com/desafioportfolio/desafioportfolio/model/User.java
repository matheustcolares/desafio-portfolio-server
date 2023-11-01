package com.desafioportfolio.desafioportfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.desafioportfolio.desafioportfolio.util.RoleEnum;

@Entity
@Table(name = "Usuario")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Username")
	private String username;
	

	@Column(name = "Registration")
	private int registration;
	
	@Column(name = "Password")
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Role")
	private RoleEnum role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User() {}
	
	public User(Long id, String name, int registration, String password, RoleEnum role) {
		super();
		this.id = id;
		this.name = name;
		this.registration = registration;
		this.password = password;
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegistration() {
		return registration;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	

}

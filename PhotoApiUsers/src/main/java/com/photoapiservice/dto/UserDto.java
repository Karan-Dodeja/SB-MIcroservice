package com.photoapiservice.dto;

import java.io.Serializable;

import jakarta.persistence.Entity;
@Entity
public class UserDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2165677891891380487L;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private long userId;
	private String encryptedPassword;
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

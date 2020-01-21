package com.example.beproject;

import java.security.SecureRandom;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String password;
	private String generatedCode = generateCode(10);
	private boolean hasDiscount = false;
	
	public Person() {
		
	}
	
	public Person(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getGeneratedCode() {
		return generatedCode;
	}

	public void setGeneratedCode(String generatedCode) {
		this.generatedCode = generatedCode;
	}

	public boolean isHasDiscount() {
		return hasDiscount;
	}

	public void setHasDiscount(boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}
	
	//Generates random code
	//
	//@param int how many characters to return
	//
	//returns string of random characters , length is specified in the input parameter.
	public String generateCode(int codeLength){   
	    char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
	      StringBuilder sb = new StringBuilder();
	      Random random = new SecureRandom();
	      for (int i = 0; i < codeLength; i++) {
	          char c = chars[random.nextInt(chars.length)];
	          sb.append(c);
	      }
	      String output = sb.toString();
	      return output ;
	  }
	

	
}

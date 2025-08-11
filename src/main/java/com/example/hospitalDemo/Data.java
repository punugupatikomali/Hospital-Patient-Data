package com.example.hospitalDemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointmentData")
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sno")
	private int sno;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	public Data() {
		super();
	}

	public Data(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
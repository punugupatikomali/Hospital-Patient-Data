package com.example.hospitalDemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalDemo.Data;
import com.example.hospitalDemo.DataRepo;

@Service
public class DataService {
    @Autowired
	private DataRepo repo;

    public Data adduser(Map<String,String> credentials) {
		
		Data temp = new Data();
		temp.setUsername(credentials.getOrDefault("username", null));
		temp.setPassword(credentials.getOrDefault("password", null));
		temp.setEmail(credentials.getOrDefault("email", null));
		return this.repo.save(temp);
		
	}

}

package com.example.hospitalDemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalDemo.Doctor;
import com.example.hospitalDemo.DoctorRepo;
import java.time.LocalTime;

@Service
public class DoctorService {
    @Autowired
	private DoctorRepo repo;

    public Doctor adduser(Map<String,String> credentials) {
		
		Doctor temp = new Doctor();
		temp.setDoctorname(credentials.getOrDefault("doctorname", null));
        temp.setSpecialization(credentials.getOrDefault("specialization", null));
        temp.setStartTime(LocalTime.parse(credentials.getOrDefault("startTime", "09:00")));
        temp.setEndTime(LocalTime.parse(credentials.getOrDefault("endTime", "17:00")));
        return this.repo.save(temp);
		
	}

}

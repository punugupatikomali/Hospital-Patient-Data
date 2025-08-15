package com.example.hospitalDemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalDemo.Appointment;
import com.example.hospitalDemo.AppointmentRepo;
import com.example.hospitalDemo.AppointmentService;
import java.time.LocalTime;
import java.time.LocalDate;

@Service
public class AppointmentService {
    @Autowired
	private AppointmentRepo repo;

    public Appointment adduser(Map<String,String> credentials) {
		
		Appointment temp = new Appointment();
        temp.setDoctorname(credentials.getOrDefault("doctorname", null));
        temp.setSpecialization(credentials.getOrDefault("specialization", null));
        temp.setAppointmentDate(LocalDate.parse(credentials.getOrDefault("appointmentDate", LocalDate.now().toString())));
        temp.setAppointmentTime(LocalTime.parse(credentials.getOrDefault("appointmentTime", "09:00")));
        temp.setLocation(credentials.getOrDefault("location", null));
        temp.setPatientName(credentials.getOrDefault("patientName", null));
        temp.setPatientContact(credentials.getOrDefault("patientContact", null));
        temp.setPatientAge(Integer.parseInt(credentials.getOrDefault("patientAge", "0")));
        temp.setGender(credentials.getOrDefault("gender", null));
        return this.repo.save(temp);
		
	}

}

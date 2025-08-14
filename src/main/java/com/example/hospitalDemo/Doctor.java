package com.example.hospitalDemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name="DoctorData")
public class Doctor{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sno")
	private int sno;
	
	@Column(name="doctorname")
	private String doctorname;
	
    @Column(name="specialization")
	private String specialization;

    @Column(name="startTime")
    private  LocalTime startTime;

    @Column(name="endTime")
    private LocalTime endTime;
	
	public Doctor() {
		super();
	}

    public Doctor(String doctorname, String specialization, LocalTime startTime, LocalTime endTime) {
        super();
        this.doctorname = doctorname;
        this.specialization = specialization;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
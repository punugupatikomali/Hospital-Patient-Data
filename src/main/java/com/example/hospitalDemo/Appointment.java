package com.example.hospitalDemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalTime;
import java.time.LocalDate;

@Entity
@Table(name="Appointmenttable")
public class Appointment{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sno")
	private int sno;
	
	@Column(name="doctorname")
	private String doctorname;
	
    @Column(name="specialization")
	private String specialization;

   @Column(name="appointment_date")
    private LocalDate appointmentDate;

    @Column(name="appointment_time")
    private LocalTime appointmentTime;
    
    @Column(name="location")
    private String location;

    @Column(name="patient_name")
    private String patientName;

    @Column(name="patient_contact")
    private String patientContact;

    @Column(name="patient_age")
    private int patientAge;

    @Column(name="gender")
    private String gender;


	public Appointment() {
		super();
	} 
	
    public Appointment(int sno, String doctorname, String specialization, LocalDate appointmentDate, LocalTime appointmentTime, String location, String patientName, String patientContact, int patientAge, String gender) {
        this.sno = sno;
        this.doctorname = doctorname;
        this.specialization = specialization;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.location = location;
        this.patientName = patientName;
        this.patientContact = patientContact;
        this.patientAge = patientAge;
        this.gender = gender;
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

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
package com.example.hospitalDemo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalDemo.Doctor;
import com.example.hospitalDemo.DoctorRepo;
import com.example.hospitalDemo.DoctorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/docdata/")
public class DoctorController {
	
	@Autowired
	private DoctorRepo DoctorRepo;
	
	@Autowired
	private DoctorService DoctorService;
	
	@GetMapping("all")
	public ResponseEntity<List<Doctor>> getAllUsers(){
	    List<Doctor> users = this.DoctorRepo.findAll();
	    if (!users.isEmpty()) {
	        return ResponseEntity.ok(users); // 200 OK
	    } else {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
	    }
	}

    @GetMapping("all/{specialization}")
	// public ResponseEntity<List<Doctor>> getAll(@PathVariable("specialization") String specialization){
        Doctor temp= this.DoctorRepo.findBySpecialization(specialization);
	    if (!temp.isEmpty()) {
	        return ResponseEntity.ok(temp); // 200 OK
	    } else {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
	    }
	

	@PostMapping("add")
	public ResponseEntity<Doctor> postUser(@RequestBody Map<String,String> credentials) {
	    Doctor user = DoctorService.adduser(credentials);
	    if (user != null) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(user); // 201 Created
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 400 Bad Request
	    }
	}
	

}

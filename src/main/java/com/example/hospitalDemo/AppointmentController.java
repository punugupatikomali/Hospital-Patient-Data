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

import com.example.hospitalDemo.Appointment;
import com.example.hospitalDemo.AppointmentRepo;
import com.example.hospitalDemo.AppointmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/appointmentdata/")
public class AppointmentController {
	
	@Autowired
	private AppointmentRepo AppointmentRepo;
	
	@Autowired
	private AppointmentService AppointmentService;
	
	@GetMapping("all")
	public ResponseEntity<List<Appointment>> getAllUsers(){
	    List<Appointment> users = this.AppointmentRepo.findAll();
	    if (!users.isEmpty()) {
	        return ResponseEntity.ok(users); // 200 OK
	    } else {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
	    }
	}

	@GetMapping("all/{doctorname}")
	public ResponseEntity<List<Appointment>> getAll(@PathVariable("doctorname") String doctorname){
		List<Appointment> users = this.AppointmentRepo.findByDoctorname(doctorname);
	    if (!users.isEmpty()) {
	        return ResponseEntity.ok(users); // 200 OK
	    } else {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
	    }
	}

	// @GetMapping("prods/{productsid}")
	// public ResponseEntity<List<Products>> getAll(@PathVariable("productsid") String productsid) {
	//     List<Products> products = this.ProductsRepo.getProdDetails(productsid);
	//     if (!products.isEmpty()) {
	//         return ResponseEntity.ok(products); // 200 OK
	//     } else {
	//         return ResponseEntity.notFound().build(); // 404 Not Found
	//     }
	// }
    // @GetMapping("all/{patient_name}")
	// public ResponseEntity<List<Appointment>> getAll(@PathVariable("patient_name") String patient_name){
	// 	List<Appointment> users = this.AppointmentRepo.findByPatientName(patient_name);
	//     if (!users.isEmpty()) {
	//         return ResponseEntity.ok(users); // 200 OK
	//     } else {
	//         return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
	//     }
	// }

	@PostMapping("add")
	public ResponseEntity<Appointment> postUser(@RequestBody Map<String,String> credentials) {
	   Appointment user = AppointmentService.adduser(credentials);
	    if (user != null) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(user); // 201 Created
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 400 Bad Request
	    }
	}
	

}

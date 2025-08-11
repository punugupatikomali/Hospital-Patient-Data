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

import com.example.hospitalDemo.Data;
import com.example.hospitalDemo.DataRepo;
import com.example.hospitalDemo.DataService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/testdata/")
public class DataController {
	
	@Autowired
	private DataRepo DataRepo;
	
	@Autowired
	private DataService DataService;
	
	@GetMapping("all")
	public ResponseEntity<List<Data>> getAllUsers(){
	    List<Data> users = this.DataRepo.findAll();
	    if (!users.isEmpty()) {
	        return ResponseEntity.ok(users); // 200 OK
	    } else {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
	    }
	}

	@PostMapping("add")
	public ResponseEntity<Data> postUser(@RequestBody Map<String,String> credentials) {
	    Data user = DataService.adduser(credentials);
	    if (user != null) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(user); // 201 Created
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 400 Bad Request
	    }
	}
	

}

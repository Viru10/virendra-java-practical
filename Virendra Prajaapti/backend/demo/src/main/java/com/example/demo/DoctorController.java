package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/v1")
public class DoctorController {

	@Autowired
	private IDoctorService doctorService;

	@PostMapping("/add")
	public ResponseEntity<String> addAppoitment(@Valid @RequestBody RequestForAppoitment appoitmentRequest)
			throws Throwable {
		doctorService.addAppoitment(appoitmentRequest);
		return new ResponseEntity<String>("Appitment submitted successfully", HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllAppoitment() {
		List<RequestForAppoitment> list = doctorService.getAllAppoitment();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PutMapping("/edit")
	public ResponseEntity<String> update(@Valid @RequestBody RequestForAppoitment appoitmentRequest) throws Throwable {
		doctorService.updateAppoitment(appoitmentRequest);
		return new ResponseEntity<String>("Appitment updated successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getAll/doctors")
	public ResponseEntity<?> getAllDoctor() {
		List<RequestForAppoitment> list = doctorService.getAllDoctorList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}

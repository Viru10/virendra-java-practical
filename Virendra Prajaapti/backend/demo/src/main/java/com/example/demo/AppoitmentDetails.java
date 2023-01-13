package com.example.demo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppoitmentDetails {
	private String patientName;
	private Double patientMobileNo;
	private Date appoitmentDate;
	private String emailId;
	private Date dob;
}

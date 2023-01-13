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
public class DoctorAppoitmentDetails {
	private String doctorName;
	private Date fromAppoitmentDate;
	private Date toAppoitmentDate;
	private String status;
	private AppoitmentDetails appoitmentDetails;
}

package com.example.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appoitment")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppoitmentDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "patient_name")
	private String patientName;

	@Column(name = "emailId")
	private String emailId;

	@Column(name = "mobile_no")
	private Double mobileNo;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "appoitment_date")
	private Date appoitmentDate;

	@Column(name = "status")
	private String status;

	@ManyToOne
	private DoctorDao doctor;

}

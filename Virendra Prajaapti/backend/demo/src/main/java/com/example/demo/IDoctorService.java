package com.example.demo;

import java.util.List;

import javax.validation.Valid;

public interface IDoctorService {

	void addAppoitment(RequestForAppoitment appoitmentRequest) throws Throwable;

	List<RequestForAppoitment> getAllAppoitment();

	void updateAppoitment(RequestForAppoitment appoitmentRequest) throws Throwable ;

	List<RequestForAppoitment> getAllDoctorList();

}

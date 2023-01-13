package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorServiceImpl implements IDoctorService {

	public static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

	@Autowired
	private IAppoitmentRepository appoitmentRepository;

	@Autowired
	private IDoctorRepository doctorRepository;

	@Override
	public void addAppoitment(RequestForAppoitment appoitmentRequest) throws Throwable {
		DoctorDao doctorData = doctorRepository.findById(appoitmentRequest.getDoctorId()).orElseThrow(() -> {
			return new Exception("Doctor not found !");
		});

		boolean flag = false;
		LocalDate fromAvailability = convertToLocalDate(doctorData.getFromAvailability());
		LocalDate toAvailability = convertToLocalDate(doctorData.getToAvailability());
		LocalDate appoitmentDate = convertToLocalDate(appoitmentRequest.getAppoitmentDetails().getAppoitmentDate());

		if (appoitmentDate.isAfter(fromAvailability) && appoitmentDate.isBefore(toAvailability)) {
			flag = true;
		}

		if (flag) {
			AppoitmentDetails appoitmentDetails = appoitmentRequest.getAppoitmentDetails();

			AppoitmentDao appoitmentDao = AppoitmentDao.builder().appoitmentDate(appoitmentDetails.getAppoitmentDate())
					.dob(appoitmentDetails.getDob()).emailId(appoitmentDetails.getEmailId())
					.mobileNo(appoitmentDetails.getPatientMobileNo())
					.patientName(appoitmentRequest.getAppoitmentDetails().getPatientName()).status("BOOKED")
					.doctor(doctorData).build();
			appoitmentRepository.save(appoitmentDao);
		} else {
			throw new Exception("Appoitment not available");
		}

	}

	public LocalDate convertToLocalDate(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	@Override
	public List<RequestForAppoitment> getAllAppoitment() {
		List<AppoitmentDao> appoitmentList = appoitmentRepository.findAll();

		List<RequestForAppoitment> list = new ArrayList<RequestForAppoitment>();
		for (AppoitmentDao dao : appoitmentList) {
			AppoitmentDetails appoitmentDetails = new AppoitmentDetails();
			appoitmentDetails.setAppoitmentDate(dao.getAppoitmentDate());
			appoitmentDetails.setDob(dao.getDob());
			appoitmentDetails.setEmailId(dao.getEmailId());
			appoitmentDetails.setPatientMobileNo(dao.getMobileNo());
			appoitmentDetails.setPatientName(dao.getPatientName());

			RequestForAppoitment detail = new RequestForAppoitment();
			detail.setDoctorId(dao.getDoctor().getId());
			detail.setDoctorName(dao.getDoctor().getDoctorName());
			detail.setDoctorSpec(dao.getDoctor().getDoctorSpecification());
			detail.setAppoitmentDetails(appoitmentDetails);
			list.add(detail);
		}
		return list;
	}

	@Override
	public void updateAppoitment(RequestForAppoitment appoitmentRequest) throws Throwable {
		DoctorDao doctorData = doctorRepository.findById(appoitmentRequest.getDoctorId()).orElseThrow(() -> {
			return new Exception("Doctor not found !");
		});

		AppoitmentDetails appoitmentDetails = appoitmentRequest.getAppoitmentDetails();

		AppoitmentDao appoitmentDao = AppoitmentDao.builder().appoitmentDate(appoitmentDetails.getAppoitmentDate())
				.dob(appoitmentDetails.getDob()).emailId(appoitmentDetails.getEmailId())
				.mobileNo(appoitmentDetails.getPatientMobileNo())
				.patientName(appoitmentRequest.getAppoitmentDetails().getPatientName()).status("BOOKED")
				.doctor(doctorData).build();

		appoitmentRepository.save(appoitmentDao);
	}

	@Override
	public List<RequestForAppoitment> getAllDoctorList() {
		List<DoctorDao> list = doctorRepository.findAll();
		List<RequestForAppoitment> doctorList = new ArrayList<RequestForAppoitment>();
		for (DoctorDao item : list) {
			RequestForAppoitment detail = new RequestForAppoitment();
			detail.setDoctorId(item.getId());
			detail.setDoctorName(item.getDoctorName());
			detail.setDoctorSpec(item.getDoctorSpecification());
			doctorList.add(detail);
		}
		return doctorList;
	}

}

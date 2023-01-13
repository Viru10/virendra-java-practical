package com.example.demo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String doctorName;

	@Column(name = "specification")
	private String doctorSpecification;

	@Column(name = "from_availablity")
	private Date fromAvailability;

	@Column(name = "to_availablity")
	private Date toAvailability;

	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<AppoitmentDao> appoitment;
}

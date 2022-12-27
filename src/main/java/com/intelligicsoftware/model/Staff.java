package com.intelligicsoftware.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "STAFF_DETAILS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
	
	@Id
	@Column(name = "staff_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long staffId;
	
	@Column(name ="staff_name")
	private String staffName;
	
	@Column(name = "staff_contact")
	private Long staffContact;
	
	@Column(name ="staff_adhar")
	private Long staffAdhar;
	
	@Column(name ="staff_designation")
	private String staffDesignation;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "staff_gender")
	private String staffGender;
	
	@Column(name ="staff_dob")
	private String staffDob;
	
	@Embedded
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	private Login login;
}

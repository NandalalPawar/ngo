package com.intelligicsoftware.model;

import javax.management.loading.PrivateClassLoader;

import org.hibernate.type.descriptor.java.LongJavaType;

import com.intelligicsoftware.dto.DonarDto;

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
@Table(name = "DONAR_DETAILS")
@Getter
@Setter
@NoArgsConstructor

public class Donar {
	@Id
	@Column(name = "donar_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donarId;
	
	@Column(name = "donar_name")
	private String donarName;
	
	@Column(name = "donar_contact")
	private Long donarContact;
	
	@Column(name = "donar_pan")
	private String donarPAN;
	
	@Column(name = "donar_gender")
	private String donarGender;
	
	@Column(name = "dob")
	private String DOB;
	
	@Column(name = "donar_amount")
	private Long donorAmount;
	
	@OneToOne
	@JoinColumn(name= "login_id")
	private Login login;
	
	@Embedded
	private Address address;
	
}

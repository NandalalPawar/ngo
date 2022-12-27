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
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	
	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adminId;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name = "admin_contact")
	private String adminContact;
	
	@Column(name = "admin_adhar")
	private String adminAdhar;
	
	@Column(name = "admin_gender")
	private String adminGender;

	@Embedded
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="login_id")
	private Login login;
	
	
	
}











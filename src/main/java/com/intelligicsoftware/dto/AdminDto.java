package com.intelligicsoftware.dto;

import com.intelligicsoftware.model.Address;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

	private Long adminId;
	
	@NotEmpty
	@Size(min =3, max=20, message="Name must be atleast 3 characters")
	private String adminName;
	
	@NotEmpty
	@Size(min=10, max=10, message="Admin contact not valid !!")
	private String adminContact;
	
	@NotEmpty
	@Size(min = 12, max=12, message="Adhar no must be 12 digid...!!")
	private String adminAdhar;
	
	@NotEmpty
	private String adminGender;
	
	@Embedded
	private Address address;
// this is admin dto class
}

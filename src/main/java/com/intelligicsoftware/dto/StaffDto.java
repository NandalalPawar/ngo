package com.intelligicsoftware.dto;

import jakarta.persistence.Column;
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
public class StaffDto {

	@NotEmpty
	@Size(min =3, max=20, message="Name must be atleast 3 characters")
	private String staffName;

	@NotEmpty
	@Size(min=10, max=10, message="Staff contact not valid !!")
	private Long staffContact;

	@NotEmpty
	@Size(min = 12, max=12, message="Adhar no must be 12 digid...!!")
	private Long staffAdhar;

	@NotEmpty
	private String staffDesignation;
	
	@NotEmpty
	private String department;

	@NotEmpty
	private String staffGender;
	@NotEmpty
	private String staffDob;

}

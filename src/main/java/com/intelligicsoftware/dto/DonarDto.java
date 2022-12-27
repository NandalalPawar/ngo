package com.intelligicsoftware.dto;

import com.intelligicsoftware.model.Address;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonarDto {

	
	private Long donarId;
	@NotEmpty
	@Size(min =3, max=20, message="Name must be atleast 3 characters")
	private String donarName;
	
	@NotEmpty
	@Size(min=10, max=10, message="Donar contact not valid !!")
	private Long donarContact;
	
	@NotEmpty
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	private String donarPAN;
	
	@NotEmpty
	private String donarGender;
	@NotEmpty
	@Past(message = "The date of birth must be in the past.")
	private String DOB;
@NotEmpty
	private Long donorAmount;
	
	@Embedded
	private Address address;
	
}

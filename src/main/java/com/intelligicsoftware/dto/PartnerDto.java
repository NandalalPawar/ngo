package com.intelligicsoftware.dto;


import jakarta.validation.constraints.NotEmpty;
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
public class PartnerDto {
	
private Long PartnerId;
	
	@NotEmpty
	@Size(min =3, max=20, message="Name must be atleast 3 characters")
	private String PartnerName;
	
	@NotEmpty
	@Size(min=10, max=10, message="Partner contact not valid !!")
	private String PartnerContact;
	
	@NotEmpty
	@Size(min = 3, max =20, message = "Please Enter Valid Organization Name")
	private String PartnerOrganization;
	
	@NotEmpty
	@Pattern(regexp = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+\\.[a-z]+(\\/[a-zA-Z0-9#]+\\/?)*$")
	private String PartnerWebsite;

}



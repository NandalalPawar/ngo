package com.intelligicsoftware.dto;

import jakarta.validation.constraints.Email;
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
public class FeedbackDto {

	private Long FeedbackId;

	@NotEmpty
	@Size(min =3, max=20, message="Name must be atleast 3 characters")
	private String FeedbackName;
	
	@Email(message="email shoild be in proper")
	private String FeedbackEmail;
	
	@NotEmpty
	private String FeedbackSuggestion;
}

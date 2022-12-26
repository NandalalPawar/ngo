package com.intelligicsoftware.dto;

import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
	private Long loginId;

	@NotEmpty
	private String loginUsername;
@NotEmpty
@Pattern(regexp = "\"^(?=.*[A-Za-z])(?=.*\\\\d)(?=.*[@$!%*#?&])[A-Za-z\\\\d@$!%*#?&]{8,}$\")")
	private String loginPassword;
@NotEmpty
	private String loginType;

}

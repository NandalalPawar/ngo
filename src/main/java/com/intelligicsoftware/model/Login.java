package com.intelligicsoftware.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "login_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {
	
	@Id
	@Column(name = "login_id")
	private Long loginId;
	
	@Column(name = "login_username")
	private String loginUsername;
	
	@Column(name = "login_password")
	private String ginPassword;
	
	@Column(name = "login_type")
	private String loginType;


}

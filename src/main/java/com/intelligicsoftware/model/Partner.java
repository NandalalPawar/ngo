package com.intelligicsoftware.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "Partnar_Details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Partner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partner_id")
	private Long PartnerId;
	
	@Column(name = "partner_name")
	private String PartnerName;
	
	@Column(name = "partner_contact")
	private String PartnerContact;
	
	@Column(name = "partner_organisation")
	private String PartnerOrganisation;
	
	@Column(name = "partner_website")
	private String PartnerWebsite;

}

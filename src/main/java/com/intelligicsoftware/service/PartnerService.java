package com.intelligicsoftware.service;

import java.util.List;

import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.dto.PartnerDto;

public interface PartnerService {
public PartnerDto createPartner(PartnerDto partnerDto);
	
	public PartnerDto updatePartner(PartnerDto partnerDto, Long partnerId);
	
	public List<PartnerDto> getAllPartner();
	
	public void deletePartner(Long partnerId);

	public PartnerDto getPartnerByLogin(LoginDto login);
}
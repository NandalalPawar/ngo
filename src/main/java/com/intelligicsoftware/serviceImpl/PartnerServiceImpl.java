package com.intelligicsoftware.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.dto.PartnerDto;
import com.intelligicsoftware.dto.StaffDto;
import com.intelligicsoftware.exception.ResourceNotFoundException;
import com.intelligicsoftware.model.Partner;
import com.intelligicsoftware.model.Staff;
import com.intelligicsoftware.repository.PartnerRepo;
import com.intelligicsoftware.service.PartnerService;


@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerRepo partnerRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PartnerDto createPartner(PartnerDto partnerDto) {
		Partner partner = this.modelMapper.map(partnerDto, Partner.class);
		Partner savePartner = this.partnerRepo.save(partner);
		return this.modelMapper.map(savePartner, PartnerDto.class);
	}

	@Override
	public PartnerDto updatePartner(PartnerDto partnerDto, Long partnerId) {
		Partner partner = this.partnerRepo.findById(partnerId)
				.orElseThrow(() -> new ResourceNotFoundException("Partner", "Partner Id", partnerId));
		partner.setPartnerName(partnerDto.getPartnerName());
		partner.setPartnerContact(partnerDto.getPartnerContact());
		partner.setPartnerOrganisation(partnerDto.getPartnerOrganization());
		partner.setPartnerWebsite(partnerDto.getPartnerWebsite());
		Partner updatePartner = this.partnerRepo.save(partner);
		return this.modelMapper.map(updatePartner, PartnerDto.class);
	}

	@Override
	public List<PartnerDto> getAllPartner() {
		List<Partner> partnerList = this.partnerRepo.findAll();
		List<PartnerDto> partnerDtos = partnerList.stream()
				.map((partner) -> this.modelMapper.map(partner, PartnerDto.class)).collect(Collectors.toList());
		return partnerDtos;
	}

	@Override
	public void deletePartner(Long partnerId) {
		Partner partner = this.partnerRepo.findById(partnerId)
				.orElseThrow(() -> new ResourceNotFoundException("Partner", "Partner Id", partnerId));
		this.partnerRepo.delete(partner);

}

	@Override
	public PartnerDto getPartnerByLogin(LoginDto login) {
		Partner findByLogin = this.partnerRepo.findByLogin(login);
		PartnerDto map = this.modelMapper.map(findByLogin, PartnerDto.class);
		return map;
	}
	
	
}
	
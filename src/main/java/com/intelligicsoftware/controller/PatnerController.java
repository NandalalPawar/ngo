package com.intelligicsoftware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intelligicsoftware.constants.AppConstants;
import com.intelligicsoftware.dto.PartnerDto;
import com.intelligicsoftware.payloads.ApiResponse;
import com.intelligicsoftware.service.PartnerService;
@RequestMapping("/api")
public class PatnerController {
	@Autowired
	private PartnerService partnerService;
	
	@PostMapping("/savePartner")
	public ResponseEntity<PartnerDto> createPartner(@RequestBody PartnerDto partnerDto)
	{
		PartnerDto createPartner = this.partnerService.createPartner(partnerDto);
		return new ResponseEntity<PartnerDto>(createPartner, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updatePartner/{partnerId}")
	public ResponseEntity<PartnerDto> updatePartner(@RequestBody PartnerDto partnerDto, @PathVariable Long partnerId)
	{
           PartnerDto updatePartner = this.partnerService.updatePartner(partnerDto, partnerId);
           return new ResponseEntity<PartnerDto>(updatePartner,HttpStatus.OK);
	}
	
	@GetMapping("/getPartner")
	public ResponseEntity<List<PartnerDto>> getPartner()
	{
		List<PartnerDto> allPartner = this.partnerService.getAllPartner();
		return new ResponseEntity<List<PartnerDto>>(allPartner,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePartner/{partnerId}")
	public ResponseEntity<ApiResponse> deletePartner(@PathVariable Long partnerId)
	{
		this.partnerService.deletePartner(partnerId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.DELETE_PARTNER + partnerId, false), HttpStatus.OK);
	}
	
	
}

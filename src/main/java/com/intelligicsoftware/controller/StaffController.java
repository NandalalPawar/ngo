package com.intelligicsoftware.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelligicsoftware.constants.AppConstants;
import com.intelligicsoftware.dto.StaffDto;
import com.intelligicsoftware.payloads.ApiResponse;
import com.intelligicsoftware.repository.StaffRepository;
import com.intelligicsoftware.service.StaffService;

@RestController
@RequestMapping("/api")
public class StaffController {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StaffService staffService;

	
	@PostMapping("/createStaff")
public ResponseEntity<StaffDto>createStaff(@RequestBody StaffDto staffDto){
	StaffDto createStaff = this.staffService.createStaff(staffDto);
	return new ResponseEntity<StaffDto>(createStaff, HttpStatus.CREATED);	
	
}
	@PutMapping("/updateStaff/{staffId}")
	public ResponseEntity<StaffDto>updateStaff(@RequestBody StaffDto staffDto,@PathVariable Long staffId){
		StaffDto updateStaff = this.staffService.updateStaff(staffDto, staffId);
		return new ResponseEntity<StaffDto>(updateStaff, HttpStatus.OK);
				
	}
	
	@GetMapping("/getAllstaff")
	public ResponseEntity<List<StaffDto>> getAllStaff(){
	List<StaffDto> allStaff = this.staffService.getAllStaff();
	return new ResponseEntity<List<StaffDto>>(allStaff,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStaff/{staffId}")
	public ResponseEntity<ApiResponse>deleteStaff(@PathVariable Long staffId){
		this.staffService.deleteStaff(staffId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.DELETE_STAFF, false), HttpStatus.OK);
	}
	
	
}

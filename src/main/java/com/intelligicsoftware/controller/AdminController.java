package com.intelligicsoftware.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestController;

import com.intelligicsoftware.constants.AppConstants;
import com.intelligicsoftware.dto.AdminDto;
import com.intelligicsoftware.payloads.ApiResponse;
import com.intelligicsoftware.service.AdminService;


@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@PostMapping("/createAdmin")
	public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto) {
		AdminDto createAdmin = this.adminService.createAdmin(adminDto);
		return new ResponseEntity<AdminDto>(createAdmin, HttpStatus.CREATED);
	}

	@PutMapping("/updateAdmin/{adminId}")
	public ResponseEntity<AdminDto> updateAdmin(@RequestBody AdminDto adminDto, @PathVariable Long adminId) {
		AdminDto updateAdmin = this.adminService.updateAdmin(adminDto, adminId);
		return new ResponseEntity<AdminDto>(updateAdmin, HttpStatus.OK);

	}

	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<AdminDto>> getAllAdmin() {
		List<AdminDto> adminDtos = this.adminService.getAllAdmin();
		return new ResponseEntity<List<AdminDto>>(adminDtos, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAdmin/{adminId}")
	public ResponseEntity<ApiResponse> deleteAdmin(@PathVariable Long adminId) {
		this.adminService.deleteAdmin(adminId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.DELETE_ADMIN, false), HttpStatus.OK);
	}

}

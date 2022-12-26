package com.intelligicsoftware.service;

import java.util.List;

import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.dto.StaffDto;


public interface StaffService {

	public StaffDto createStaff(StaffDto staffDto);

	public StaffDto updateStaff(StaffDto staffDto, Long staffId);

	public List<StaffDto> getAllStaff();

	public void deleteStaff(Long staffId);
	
	public StaffDto getStaffByLogin(LoginDto login);

}

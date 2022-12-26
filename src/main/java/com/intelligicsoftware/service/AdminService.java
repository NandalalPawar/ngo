package com.intelligicsoftware.service;

import java.util.List;

import com.intelligicsoftware.dto.AdminDto;
import com.intelligicsoftware.dto.LoginDto;

public interface AdminService {
	
	public AdminDto createAdmin(AdminDto adminDto);
	
	public AdminDto updateAdmin(AdminDto adminDto, Long adminId);
	
	public List<AdminDto> getAllAdmin();
	
	public void deleteAdmin(Long adminId);

	public AdminDto getAdminByLogin(LoginDto login);

}

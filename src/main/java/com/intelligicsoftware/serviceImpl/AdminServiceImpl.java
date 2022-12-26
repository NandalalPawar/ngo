package com.intelligicsoftware.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligicsoftware.constants.AppConstants;
import com.intelligicsoftware.controller.AdminController;
import com.intelligicsoftware.dto.AdminDto;
import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.exception.ResourceNotFoundException;
import com.intelligicsoftware.model.Admin;
import com.intelligicsoftware.repository.AdminRepository;
import com.intelligicsoftware.service.AdminService;



@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ModelMapper modelmapper;
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Override
	public AdminDto createAdmin(AdminDto adminDto) {
		logger.info("Initiating dao call for save the admin details");
		Admin map = this.modelmapper.map(adminDto, Admin.class);
		Admin save = this.adminRepository.save(map);
		logger.info("Completed dao call for save the admin details");
		return this.modelmapper.map(save, AdminDto.class);
	}

	@Override
	public AdminDto updateAdmin(AdminDto adminDto, Long adminId) {
		logger.info("Initiating dao call for update the admin details with :{}", adminId);
		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "AdminId", adminId));
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminContact(adminDto.getAdminContact());
		admin.setAdminAdhar(adminDto.getAdminAdhar());
		admin.setAdminGender(adminDto.getAdminGender());
		Admin saveAdmin = this.adminRepository.save(admin);
		logger.info("Completed dao call for update the admin details");
		return this.modelmapper.map(saveAdmin, AdminDto.class);
	}

	@Override
	public List<AdminDto> getAllAdmin() {
		logger.info("Initiating dao call for getAll the admin details");
		List<Admin> list = this.adminRepository.findAll();
		List<AdminDto> adminDtos = list.stream().map((admin) -> this.modelmapper.map(admin, AdminDto.class))
				.collect(Collectors.toList());
		logger.info("Completed dao call for getAll the admin details");	
		return adminDtos;
	}

	@Override
	public void deleteAdmin(Long adminId) {
		logger.info("Initiating dao call for delete the admin detail swith :{]", adminId);	
		
		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(()->new ResourceNotFoundException("admin","adminId",adminId));
		
		logger.info("Completed dao call for delete the admin detail swith :{]", adminId);	
		this.adminRepository.delete(admin);
	}

	@Override
	public AdminDto getAdminByLogin(LoginDto login) {
		Admin findByLogin = this.adminRepository.findByLogin(login);
		AdminDto adminDto = this.modelmapper.map(findByLogin, AdminDto.class);
		return adminDto;
	}

}

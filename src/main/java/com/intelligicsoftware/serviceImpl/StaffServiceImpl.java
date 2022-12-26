               package com.intelligicsoftware.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intelligicsoftware.controller.StaffController;
import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.dto.StaffDto;
import com.intelligicsoftware.exception.ResourceNotFoundException;
import com.intelligicsoftware.model.Staff;
import com.intelligicsoftware.repository.StaffRepository;
import com.intelligicsoftware.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	Logger logger = LoggerFactory.getLogger(StaffController.class);
	@Override
	public StaffDto createStaff(StaffDto staffDto) {
		logger.info("Initiating dao call for save the staff details");
		Staff staff = this.modelMapper.map(staffDto, Staff.class);
		Staff save = this.staffRepository.save(staff);
		StaffDto dtoObj = this.modelMapper.map(save, StaffDto.class);
		logger.info("Completed dao call for save the staff details");
		return dtoObj;
	}

	@Override
	public StaffDto updateStaff(StaffDto staffDto, Long staffId) {
		logger.info("Initiating dao call for update the staff details with :{}", staffId);
		Staff staff = this.staffRepository.findById(staffId)
				.orElseThrow(() -> new ResourceNotFoundException("Staff", "StaffId", staffId));
		staff.setStaffName(staffDto.getStaffName());
		staff.setStaffAdhar(staffDto.getStaffAdhar());
		staff.setStaffContact(staffDto.getStaffContact());
		staff.setStaffDesignation(staffDto.getStaffDesignation());
		staff.setStaffGender(staffDto.getStaffGender());
		staff.setStaffDob(staffDto.getStaffDob());
		Staff updateStaff = this.staffRepository.save(staff);
		StaffDto dtos = this.modelMapper.map(updateStaff, StaffDto.class);
		logger.info("Completed dao call for update the staff details");
		return dtos;
	}

	@Override
	public List<StaffDto> getAllStaff() {
		logger.info("Initiating dao call for getAll the staff details");
		List<Staff> list = this.staffRepository.findAll();
		List<StaffDto> staffDtos = list.stream().map((staff) -> this.modelMapper.map(staff, StaffDto.class))
				.collect(Collectors.toList());
		logger.info("Completed dao call for getAll the staff details");	
		return staffDtos;
	}

	@Override
	public void deleteStaff(Long staffId) {
		logger.info("Initiating dao call for delete the staff detail swith :{]", staffId);	
		Staff staff = this.staffRepository.findById(staffId)
				.orElseThrow(() -> new ResourceNotFoundException("Staff", "Staff Id", staffId));
		logger.info("Completed dao call for delete the staff detail swith :{]", staffId);
		this.staffRepository.delete(staff);

	}

	@Override
	public StaffDto getStaffByLogin(LoginDto login) {
		Staff staff = this.staffRepository.findByLogin(login);
		StaffDto map = this.modelMapper.map(staff, StaffDto.class);
		return map;
	}

}

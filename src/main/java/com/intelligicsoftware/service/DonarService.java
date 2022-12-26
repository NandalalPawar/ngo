package com.intelligicsoftware.service;

import java.util.List;

import com.intelligicsoftware.dto.DonarDto;
import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.dto.StaffDto;



public interface DonarService {
	public DonarDto createDonar(DonarDto donarDto);

	public DonarDto updateDonar(DonarDto donarDto, Long donarId);

	public List<DonarDto> getAllDonar();

	public void deleteDonar(Long staffId);

	public DonarDto getDonarByLogin(LoginDto login);
	
}

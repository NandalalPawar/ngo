package com.intelligicsoftware.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligicsoftware.dto.DonarDto;
import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.dto.StaffDto;
import com.intelligicsoftware.exception.ResourceNotFoundException;
import com.intelligicsoftware.model.Donar;
import com.intelligicsoftware.model.Staff;
import com.intelligicsoftware.repository.DonarRepo;
import com.intelligicsoftware.service.DonarService;
@Service
public class DonarServiceImpl implements DonarService {
@Autowired
	public DonarRepo donarRepo;
	@Autowired
	public ModelMapper modelMapper;
	
	
	
	@Override
	public DonarDto createDonar(DonarDto donarDto) {
		Donar map = this.modelMapper.map(donarDto, Donar.class);
		Donar save = this.donarRepo.save(map);
		DonarDto dto = this.modelMapper.map(save, DonarDto.class);
		
		return dto;
	}

	@Override
	public DonarDto updateDonar(DonarDto donarDto, Long donarId) {
		Donar donar = this.donarRepo.findById(donarId)
				.orElseThrow(() -> new ResourceNotFoundException("Donar", "DonarId", donarId));
		
		donar.setDonarName(donarDto.getDonarName());
		donar.setDonarGender(donarDto.getDonarGender());
		donar.setDonarContact(donarDto.getDonarContact());
		donar.setDOB(donarDto.getDOB());
		donar.setDonarPAN(donarDto.getDonarPAN());
		donar.setDonorAmount(donarDto.getDonorAmount());
		
				
		Donar update = this.donarRepo.save(donar);
		DonarDto map = this.modelMapper.map(update, DonarDto.class);
	return map;	
		
	
	}
	

	@Override
	public List<DonarDto> getAllDonar() {
		
		
		List<Donar> list = this.donarRepo.findAll();
		List<DonarDto> donarDtos = list.stream().map((donar) -> this.modelMapper.map(donar, DonarDto.class))
				.collect(Collectors.toList());
	
		return donarDtos;
	}

	@Override
	public void deleteDonar(Long donarId) {
		
	Donar donar= this.donarRepo.findById(donarId)
				.orElseThrow(() -> new ResourceNotFoundException("Donar", "DonarId", donarId));
		
		this.donarRepo.delete(donar);
		
	}

	@Override
	public DonarDto getDonarByLogin(LoginDto login) {
		Donar findByLogin = this.donarRepo.findByLogin(login);
		DonarDto donarDto = this.modelMapper.map(findByLogin, DonarDto.class);
		return donarDto;
	}

}

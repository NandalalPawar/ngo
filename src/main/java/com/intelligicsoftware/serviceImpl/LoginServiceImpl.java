package com.intelligicsoftware.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.model.Login;
import com.intelligicsoftware.repository.LoginRepo;
import com.intelligicsoftware.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginRepo LoginRepo;
	@Autowired
	public ModelMapper modelMapper;
	
	
	public LoginDto getLogin(String LoginUserName, String LoginPaswword) {
		Login login = this.LoginRepo.getbyLoginUsernameAndLoginPassword(LoginUserName, LoginPaswword);
		LoginDto map = this.modelMapper.map(login, LoginDto.class);
		
		return map;
	}

}

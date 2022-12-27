package com.intelligicsoftware.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.model.Login;
import com.intelligicsoftware.repository.LoginRepo;
import com.intelligicsoftware.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginRepo LoginRepo;
	@Autowired
	public ModelMapper modelMapper;

	public LoginDto getLogin(String LoginUserName, String LoginPassword) {
		Login login = this.LoginRepo.findByLoginUsernameAndLoginPassword(LoginUserName, LoginPassword);
		LoginDto map = this.modelMapper.map(login, LoginDto.class);

		return map;
	}

}

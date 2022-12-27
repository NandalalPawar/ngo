package com.intelligicsoftware.service;

import com.intelligicsoftware.dto.LoginDto;

public interface LoginService {
public LoginDto getLogin(String LoginUserName, String LoginPassword);

}

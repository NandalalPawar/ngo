package com.intelligicsoftware.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.model.Donar;


public interface DonarRepo extends JpaRepository<Donar, Long > {
	
	Donar findByLogin(LoginDto login);

}

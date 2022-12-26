package com.intelligicsoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.model.Partner;



public interface PartnerRepo extends JpaRepository<Partner, Long> {
	Partner findByLogin(LoginDto login);
}

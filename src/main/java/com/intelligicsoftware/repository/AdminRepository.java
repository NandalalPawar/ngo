package com.intelligicsoftware.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Serializable>{

	Admin findByLogin(LoginDto login);
}

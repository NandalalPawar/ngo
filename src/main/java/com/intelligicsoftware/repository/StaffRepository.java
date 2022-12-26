package com.intelligicsoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long>{


Staff findByLogin(LoginDto login);
}

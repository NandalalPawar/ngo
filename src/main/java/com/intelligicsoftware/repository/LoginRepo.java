package com.intelligicsoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intelligicsoftware.model.Login;

public interface LoginRepo extends JpaRepository<Login, Long> {

	@Query(name = "select new package.login(a.login_username, a.login_password) from login a")


	Login getbyLoginUsernameAndLoginPassword(String loginUserName, String loginPaswword);

	
}

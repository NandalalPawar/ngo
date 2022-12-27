package com.intelligicsoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.intelligicsoftware.dto.FeedbackDto;
import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.model.Feedback;
import com.intelligicsoftware.model.Staff;

public interface FeedbackRepo extends JpaRepository<Feedback, Long>{

	Feedback findByLogin(LoginDto login);


}

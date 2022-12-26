package com.intelligicsoftware.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Feedback_Details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private Long FeedbackId;
	
	@Column(name = "feedback_name")
	private String FeedbackName;
	
	@Column(name = "feedback_email")
	private String FeedbackEmail;
	
	@Column(name = "feedback_suggestion")
	private String FeedbackSuggestion;
}

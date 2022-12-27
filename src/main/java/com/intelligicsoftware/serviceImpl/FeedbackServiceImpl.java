package com.intelligicsoftware.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligicsoftware.dto.FeedbackDto;
import com.intelligicsoftware.exception.ResourceNotFoundException;
import com.intelligicsoftware.model.Feedback;
import com.intelligicsoftware.repository.FeedbackRepo;
import com.intelligicsoftware.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepo feedbackRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public FeedbackDto saveFeedback(FeedbackDto feedbackDto) {
		Feedback feedback = this.modelMapper.map(feedbackDto, Feedback.class);
		Feedback save = this.feedbackRepo.save(feedback);
		FeedbackDto map = this.modelMapper.map(save, FeedbackDto.class);

		return map;

	}

	@Override
	public FeedbackDto updateFeedback(FeedbackDto feedbackDto, Long feedbackId) {
		Feedback feedback = this.feedbackRepo.findById(feedbackId)
				.orElseThrow(() -> new ResourceNotFoundException("feedback", "feedback", feedbackId));

		feedback.setFeedbackName(feedbackDto.getFeedbackName());
		feedback.setFeedbackEmail(feedbackDto.getFeedbackEmail());
		feedback.setFeedbackSuggestion(feedbackDto.getFeedbackSuggestion());
		Feedback save = this.feedbackRepo.save(feedback);

		return this.modelMapper.map(save, FeedbackDto.class);
	}

	@Override
	public List<FeedbackDto> getAllFeedback() {
		List<Feedback> findAll = this.feedbackRepo.findAll();
		List<FeedbackDto> collect = findAll.stream().map((feedback) -> this.modelMapper.map(feedback, FeedbackDto.class))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public void deleteFeedback(Long feedbackId) {
		Feedback feedback = this.feedbackRepo.findById(feedbackId)
				.orElseThrow(() -> new ResourceNotFoundException("feedback", "feedbackId", feedbackId));
		this.feedbackRepo.delete(feedback);

	}

}

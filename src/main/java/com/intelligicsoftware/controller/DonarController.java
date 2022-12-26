package com.intelligicsoftware.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelligicsoftware.dto.DonarDto;
import com.intelligicsoftware.service.DonarService;

@RestController
@RequestMapping("/api")
public class DonarController {
	
	@Autowired
	public DonarService donarService;
	
	@Autowired
	public ModelMapper modelMapper;
	
	@PostMapping("/createDonar")
	public ResponseEntity<DonarDto>createDonar(@RequestBody DonarDto donarDto){
		DonarDto createDonar = this.donarService.createDonar(donarDto);
		return new ResponseEntity<DonarDto>(createDonar,HttpStatus.CREATED);
	}
@PutMapping("/updateDonar/{DonarId}")
	public ResponseEntity<DonarDto>updateDonar(@RequestBody DonarDto donarDto, @PathVariable Long DonarId){
		DonarDto updateDonar = this.donarService.updateDonar(donarDto, DonarId);
		return new ResponseEntity<DonarDto>(updateDonar, HttpStatus.OK);
		
		
	}



	
}

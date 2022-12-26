package com.intelligicsoftware.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MyConfig {

	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}

}

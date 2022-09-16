package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
@CrossOrigin
@SpringBootApplication
public class SmartClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartClassApplication.class, args);

	}
	@Bean
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}

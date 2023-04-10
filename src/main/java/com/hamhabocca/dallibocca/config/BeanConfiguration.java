package com.hamhabocca.dallibocca.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.hamhabocca.dallibocca")
public class BeanConfiguration {

	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();
	}

}

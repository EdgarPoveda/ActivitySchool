package co.activityschool.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class entityServiceConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}

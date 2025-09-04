package com.ecommerce.ecommerce_app.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // config file every config related to app will be created here
    // like first is model mapper which will map the similar objects
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

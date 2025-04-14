package com.example.clientesApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.clientesApi.services.exceptions.feignexceptions.FeignErrorDecoder;


@Configuration
public class FeignConfig {

	@Bean
    FeignErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecoder();
    }
}

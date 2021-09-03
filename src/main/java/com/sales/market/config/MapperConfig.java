package com.sales.market.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        //centralizar como se comportara el mapper para toda la applicacion
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}

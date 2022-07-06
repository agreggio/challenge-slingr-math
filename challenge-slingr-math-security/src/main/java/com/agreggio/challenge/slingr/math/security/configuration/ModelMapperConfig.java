package com.agreggio.challenge.slingr.math.security.configuration;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setAmbiguityIgnored(true)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setPropertyCondition(Conditions.isNotNull())
                .setFieldAccessLevel(AccessLevel.PRIVATE);
        return modelMapper;
    }

}

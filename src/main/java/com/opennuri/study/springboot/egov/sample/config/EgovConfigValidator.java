package com.opennuri.study.springboot.egov.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springmodules.validation.commons.DefaultBeanValidator;
import org.springmodules.validation.commons.DefaultValidatorFactory;

import java.io.IOException;

@Configuration
public class EgovConfigValidator {

    @Bean
    public DefaultValidatorFactory validatorFactory() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:/egovframework/validator/*.xml");
        DefaultValidatorFactory validatorFactory = new DefaultValidatorFactory();
        validatorFactory.setValidationConfigLocations(resources);
        return validatorFactory;
    }

    @Bean
    public DefaultBeanValidator beanValidator() throws IOException {
        DefaultBeanValidator defaultBeanValidator = new DefaultBeanValidator();
        defaultBeanValidator.setValidatorFactory(validatorFactory());
        return defaultBeanValidator;
    }
}

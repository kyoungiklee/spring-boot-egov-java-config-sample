package com.opennuri.study.springboot.egov.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        EgovConfigCommon.class,
        EgovConfigIdGeneration.class,
        EgovConfigDataSource.class,
        EgovConfigProperties.class,
        EgovConfigTransaction.class,
        EgovConfigAspect.class
})
public class EgovConfig {
}

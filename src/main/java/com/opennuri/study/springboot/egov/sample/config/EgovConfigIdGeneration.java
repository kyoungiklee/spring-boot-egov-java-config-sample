package com.opennuri.study.springboot.egov.sample.config;

import org.egovframe.rte.fdl.idgnr.impl.EgovTableIdGnrServiceImpl;
import org.egovframe.rte.fdl.idgnr.impl.strategy.EgovIdGnrStrategyImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class EgovConfigIdGeneration {

    @Bean
    public EgovIdGnrStrategyImpl mixPrefixSample() {
        EgovIdGnrStrategyImpl egovIdGnrStrategy = new EgovIdGnrStrategyImpl();
        egovIdGnrStrategy.setPrefix("SAMPLE-");
        egovIdGnrStrategy.setCipers(5);
        egovIdGnrStrategy.setFillChar('0');
        return egovIdGnrStrategy;
    }

    @Bean(name = "boardSnGnrService", destroyMethod = "destroy")
    public EgovTableIdGnrServiceImpl egovIdGnrService(@Qualifier("dataSource")DataSource dataSource) {
        EgovTableIdGnrServiceImpl egovTableIdGnrService = new EgovTableIdGnrServiceImpl();
        egovTableIdGnrService.setDataSource(dataSource);
        egovTableIdGnrService.setStrategy(mixPrefixSample());
        egovTableIdGnrService.setBlockSize(10);
        egovTableIdGnrService.setTable("IDS");
        egovTableIdGnrService.setTableName("SAMPLE");
        egovTableIdGnrService.setTableNameFieldName("TABLE_NAME");
        egovTableIdGnrService.setNextIdFieldName("NEXT_ID");
        return egovTableIdGnrService;
    }
}

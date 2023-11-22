package com.opennuri.study.springboot.egov.sample;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.opennuri")
public class SpringBootEgovSampleApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootEgovSampleApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setLogStartupInfo(false);
        springApplication.run(args);
    }

}

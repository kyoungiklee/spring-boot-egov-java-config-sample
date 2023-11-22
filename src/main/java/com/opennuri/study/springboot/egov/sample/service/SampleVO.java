package com.opennuri.study.springboot.egov.sample.service;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class SampleVO extends SampleDefaultVO {
    private String id;
    private String name;
    private String description;
    private String useYn;
    private String regUser;
}

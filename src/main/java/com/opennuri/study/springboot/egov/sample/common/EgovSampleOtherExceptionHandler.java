package com.opennuri.study.springboot.egov.sample.common;

import lombok.extern.slf4j.Slf4j;
import org.egovframe.rte.fdl.cmmn.exception.handler.ExceptionHandler;

@Slf4j
public class EgovSampleOtherExceptionHandler implements ExceptionHandler {
    @Override
    public void occur(Exception e, String packageName) {
        log.debug("EgovSampleOtherExceptionHandler run.....");
    }
}

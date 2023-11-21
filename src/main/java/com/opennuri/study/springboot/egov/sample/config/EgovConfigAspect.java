package com.opennuri.study.springboot.egov.sample.config;

import com.opennuri.study.springboot.egov.sample.common.AopExceptionTransfer;
import com.opennuri.study.springboot.egov.sample.common.EgovSampleExceptionHandler;
import com.opennuri.study.springboot.egov.sample.common.EgovSampleOtherExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.egovframe.rte.fdl.cmmn.aspect.ExceptionTransfer;
import org.egovframe.rte.fdl.cmmn.exception.handler.ExceptionHandler;
import org.egovframe.rte.fdl.cmmn.exception.manager.DefaultExceptionHandleManager;
import org.egovframe.rte.fdl.cmmn.exception.manager.ExceptionHandlerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableAspectJAutoProxy
@RequiredArgsConstructor
public class EgovConfigAspect {

    private final AntPathMatcher antPathMatcher;

    @Bean
    public EgovSampleExceptionHandler egovHandler() {
        return new EgovSampleExceptionHandler();
    }

    @Bean
    public EgovSampleOtherExceptionHandler otherHandler() {
        return new EgovSampleOtherExceptionHandler();
    }

    @Bean
    public DefaultExceptionHandleManager defaultExceptionHandleManager(EgovSampleExceptionHandler egovHandler) {
        DefaultExceptionHandleManager defaultExceptionHandleManager = new DefaultExceptionHandleManager();
        defaultExceptionHandleManager.setReqExpMatcher(antPathMatcher);
        defaultExceptionHandleManager.setPatterns(new String[] {"**service.impl.*"});
        defaultExceptionHandleManager.setHandlers(new ExceptionHandler[] {egovHandler});
        return defaultExceptionHandleManager;
    }

    @Bean
    public DefaultExceptionHandleManager otherExceptionHandleManager() {
        DefaultExceptionHandleManager defaultExceptionHandleManager = new DefaultExceptionHandleManager();
        defaultExceptionHandleManager.setReqExpMatcher(antPathMatcher);
        defaultExceptionHandleManager.setPatterns(new String[]{"**service.impl.*"});
        defaultExceptionHandleManager.setHandlers(new ExceptionHandler[]{otherHandler()});
        return defaultExceptionHandleManager;
    }

    @Bean
    public ExceptionTransfer exceptionTransfer(
            @Qualifier("defaultExceptionHandleManager") DefaultExceptionHandleManager defaultExceptionHandleManager,
            @Qualifier("otherExceptionHandleManager")DefaultExceptionHandleManager otherExceptionHandlerManager) {
        ExceptionTransfer exceptionTransfer = new ExceptionTransfer();
        exceptionTransfer.setExceptionHandlerService(
                new ExceptionHandlerService[]{defaultExceptionHandleManager, otherExceptionHandlerManager});
        return exceptionTransfer;
    }

    @Bean
    public AopExceptionTransfer aopExeptionTransfer(ExceptionTransfer exceptionTransfer) {

        return null;

    }
}

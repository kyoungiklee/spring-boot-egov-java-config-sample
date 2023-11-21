package com.opennuri.study.springboot.egov.sample.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.egovframe.rte.fdl.cmmn.aspect.ExceptionTransfer;

@Aspect
public class AopExceptionTransfer {

    private ExceptionTransfer exceptionTransfer;

    public void setExceptionTransfer(ExceptionTransfer exceptionTransfer) {
        this.exceptionTransfer = exceptionTransfer;
    }

    @Pointcut("execution(* com.opennuri.study.springboot.egov.sample..impl.*Impl.*(..))")
    private void exceptionTransferService() {}

    @AfterThrowing(pointcut = "exceptionTransferService()", throwing = "ex")
    public void doAfterExceptionTransferService(JoinPoint thisJoinPoint, Exception ex) throws Exception {
        exceptionTransfer.transfer(thisJoinPoint,ex);
    }
}

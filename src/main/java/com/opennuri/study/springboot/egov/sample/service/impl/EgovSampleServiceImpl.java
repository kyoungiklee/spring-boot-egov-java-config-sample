package com.opennuri.study.springboot.egov.sample.service.impl;

import com.opennuri.study.springboot.egov.sample.service.EgovSampleService;
import com.opennuri.study.springboot.egov.sample.service.SampleDefaultVO;
import lombok.extern.slf4j.Slf4j;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("sampleService")
public class EgovSampleServiceImpl extends EgovAbstractServiceImpl implements EgovSampleService {
    @Override
    public List<?> selectSampleList(SampleDefaultVO searchVO) throws Exception {
        return null;
    }

    @Override
    public int selectSampleListTotCnt(SampleDefaultVO searchVO) {
        return 0;
    }
}

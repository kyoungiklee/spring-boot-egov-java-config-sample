package com.opennuri.study.springboot.egov.sample.service.impl;

import com.opennuri.study.springboot.egov.sample.service.SampleDefaultVO;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("sampleMapper")
public interface SampleMapper {
    /**
     * 글 목록을 조회한다.
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return 글 목록
     * @exception Exception
     */
    List<?> selectSampleList(SampleDefaultVO searchVO) throws Exception;

    /**
     * 글 총 갯수를 조회한다.
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return 글 총 갯수
     * @exception
     */
    int selectSampleListTotCnt(SampleDefaultVO searchVO);
}

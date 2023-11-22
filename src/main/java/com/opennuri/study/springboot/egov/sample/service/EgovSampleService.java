package com.opennuri.study.springboot.egov.sample.service;

import java.util.List;

public interface EgovSampleService {
    /**
     * 글 목록을 조회한다.
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return 글 목록
     * @exception  Exception 글목록 조회 시 예외가 발생할 수 있다.
     */
    List<?> selectSampleList(SampleDefaultVO searchVO) throws Exception;

    /**
     * 글 총 갯수를 조회한다.
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return 글 총 갯수
     */
    int selectSampleListTotCnt(SampleDefaultVO searchVO);
}

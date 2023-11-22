package com.opennuri.study.springboot.egov.sample.web;

import com.opennuri.study.springboot.egov.sample.service.EgovSampleService;
import com.opennuri.study.springboot.egov.sample.service.SampleDefaultVO;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import javax.annotation.Resource;

@Controller
public class EgovSampleController {

    /** EgovSampleService */
    @Resource(name = "sampleService")
    private EgovSampleService sampleService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /** Validator */
    @Resource(name = "beanValidator")
    protected DefaultBeanValidator beanValidator;
    @RequestMapping(value = "/egovSampleList.do")
    public String selectSampleList(@ModelAttribute("searchVO")SampleDefaultVO searchVO, ModelMap model) {

        return "sample/egovSampleList";
    }
}

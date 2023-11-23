package com.opennuri.study.springboot.egov.sample.common.web;


import jakarta.servlet.ServletContext;
import lombok.NoArgsConstructor;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;
import org.springframework.lang.NonNull;
import org.springframework.web.context.ServletContextAware;

/*import javax.servlet.ServletContext;*/

@NoArgsConstructor
public class EgovImgPaginationRenderer extends AbstractPaginationRenderer implements ServletContextAware {
    
    private ServletContext servletContext;
    
    /*@Override
    public void setServletContext(@NonNull ServletContext servletContext) {
        this.servletContext = servletContext;
        initVariable();
        
    }*/

    private void initVariable() {
        firstPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">" + "<image src='" + servletContext.getContextPath() + "/images/egovframework/cmmn/btn_page_pre10.gif' border=0/></a>&#160;";
        previousPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">" + "<image src='" + servletContext.getContextPath() + "/images/egovframework/cmmn/btn_page_pre1.gif' border=0/></a>&#160;";
        currentPageLabel = "<strong>{0}</strong>&#160;";
        otherPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">{2}</a>&#160;";
        nextPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">" + "<image src='" + servletContext.getContextPath() + "/images/egovframework/cmmn/btn_page_next1.gif' border=0/></a>&#160;";
        lastPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">" + "<image src='" + servletContext.getContextPath() + "/images/egovframework/cmmn/btn_page_next10.gif' border=0/></a>&#160;";
    }

    @Override
    public void setServletContext(jakarta.servlet.ServletContext servletContext) {
        this.servletContext = servletContext;
        initVariable();
    }
}

package com.opennuri.study.springboot.egov.sample.config;

import com.opennuri.study.springboot.egov.sample.common.web.EgovBindingInitializer;
import com.opennuri.study.springboot.egov.sample.common.web.EgovImgPaginationRenderer;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.DefaultPaginationManager;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationRenderer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Configuration
public class EgovWebMvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/cmmn/validator.do").setViewName("cmmn/validator");
        registry.addViewController("/").setViewName("forward:/index.jsp");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter mappingHandlerAdapter = super.createRequestMappingHandlerAdapter();
        mappingHandlerAdapter.setWebBindingInitializer(new EgovBindingInitializer());
        return mappingHandlerAdapter;
    }


    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        Properties properties = getProperties();

        Properties statusCode = new Properties();
        statusCode.setProperty("cmmn/egovError", "400");
        statusCode.setProperty("cmmn/egovError", "500");

        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        exceptionResolver.setDefaultErrorView("cmmn/egovError");
        exceptionResolver.setExceptionMappings(properties);
        exceptionResolver.setStatusCodes(statusCode);
        exceptionResolvers.add(exceptionResolver);
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("org.springframework.dao.DataAccessException","cmmn/transactionFailure");
        properties.setProperty("org.springframework.transaction.TransactionException","cmmn/transactionFailure");
        properties.setProperty("org.egovframe.rte.fdl.cmmn.exception.EgovBizException","cmmn/egovError");
        properties.setProperty("org.springframework.security.AccessDeniedException","cmmn/egovError");
        properties.setProperty("java.lang.Throwable", "cmmn/egovError");
        return properties;
    }

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/egovframework/example/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public EgovImgPaginationRenderer imgPaginationRenderer() {
        return new EgovImgPaginationRenderer();
    }

    @Bean
    public DefaultPaginationManager paginationManager(EgovImgPaginationRenderer imageRenderer) {
        Map<String, PaginationRenderer> rendererType = new HashMap<>();
        rendererType.put("image", imageRenderer);
        DefaultPaginationManager defaultPaginationManager = new DefaultPaginationManager();
        defaultPaginationManager.setRendererType(rendererType);
        return defaultPaginationManager;
    }

    @Bean
    @NonNull
    public SessionLocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("language");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/");
    }

    @Bean
    public FilterRegistrationBean encodingFilterBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setForceEncoding(true);
        filter.setEncoding("UTF-8");
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("*.do");
        return registrationBean;
    }
}

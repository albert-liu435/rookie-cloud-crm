package com.rookie.bigdata.config;

import com.rookie.bigdata.filter.IDFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Class CustomFilterConfig
 * @Description 自定义过滤器
 * @Author rookie
 * @Date 2023/5/25 17:14
 * @Version 1.0
 */
@Configuration
public class CustomFilterConfig {


    @Autowired
    private IDFilter idFilter;


    @Bean
    public FilterRegistrationBean registerIDFilter() {
        FilterRegistrationBean<IDFilter> bean = new FilterRegistrationBean<>();
        bean.setOrder(1);
        bean.setFilter(idFilter);
        // 匹配"/hello/"下面的所有url
        bean.addUrlPatterns(
                "/*"
        );
        return bean;
    }

}
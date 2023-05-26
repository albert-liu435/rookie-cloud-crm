package com.rookie.bigdata.config;

import com.rookie.bigdata.filter.IDFilter;
import com.rookie.bigdata.filter.WrapperFilter;
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



    /**
     * 为解决  RequestContextHolder中多次获取请求中数据问题
     * 如下代码：
     * ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
     * HttpServletRequest request = attrs.getRequest();
     * <p>
     * //String s = IoUtil.readUtf8(request.getInputStream());
     * <p>
     * String jsonBody = RequestUtils.getJsonBody(request);
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean reqResFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        WrapperFilter wrapperFilter = new WrapperFilter();
        filterRegistrationBean.setFilter(wrapperFilter);
//        filterRegistrationBean.setOrder(Integer.MAX_VALUE);
//        filterRegistrationBean.setOrder(Integer.MIN_VALUE);
        // filterRegistrationBean.addUrlPatterns("*.json");//配置过滤规则 　　　　 return filterRegistrationBean;
        return filterRegistrationBean;
    }

}
package com.rookie.bigdata.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * @Class SPIServiceConfig
 * @Description
 * @Author rookie
 * @Date 2024/10/10 15:54
 * @Version 1.0
 */

@Configuration
@Slf4j
public class SPIServiceConfig implements InitializingBean {



    @Override
    public void afterPropertiesSet() throws Exception {

        //TODO 这里用于查询出所有的应用的相关信息

    }
}

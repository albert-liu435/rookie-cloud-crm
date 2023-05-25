package com.rookie.bigdata.service.impl;


import com.rookie.bigdata.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Class TestServiceImpl
 * @Description
 * @Author rookie
 * @Date 2023/5/25 16:36
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {

    public static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);


    @Override
    public String testMethod(String methodParam) {

        logger.info(methodParam);
        return methodParam;
    }
}

package com.rookie.bigdata.controller;

import com.rookie.bigdata.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class TestController
 * @Description controller测试类
 * @Author rookie
 * @Date 2023/5/25 16:33
 * @Version 1.0
 */
@RestController
@RequestMapping("test")
public class TestController {

    public static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;



    @RequestMapping(value = "/get")
    public String test01(){


        testService.testMethod("abc");

        logger.info("hello springboot 3.1.0");


        return "hello";

    }

}

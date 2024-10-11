package com.rookie.bigdata.mybatis.service.impl;

import com.rookie.bigdata.common.App;
import com.rookie.bigdata.common.Fans;
import com.rookie.bigdata.mybatis.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * @Class AppServiceImplTest
 * @Description
 * @Author rookie
 * @Date 2024/10/11 9:33
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
//@AutoConfigureMockMvc
@Slf4j
class AppServiceImplTest {


    @Autowired
    private AppService appService;


    @Test
    void getAllAppByType() {

        List<App> allAppByType = appService.getAllAppByType("1");
        for (App app : allAppByType) {
            log.info("获取的所有的app:{}", app.toString());
        }
    }
}

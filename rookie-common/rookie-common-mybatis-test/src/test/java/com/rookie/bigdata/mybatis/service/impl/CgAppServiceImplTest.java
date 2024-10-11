package com.rookie.bigdata.mybatis.service.impl;

import com.rookie.bigdata.common.CgApp;
import com.rookie.bigdata.mybatis.service.CgAppService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
class CgAppServiceImplTest {


    @Autowired
    private CgAppService appService;


    @Test
    void getAllAppByType() {

        List<CgApp> allAppByType = appService.getAllAppByType("1");
        for (CgApp app : allAppByType) {
            log.info("获取的所有的app:{}", app.toString());
        }
    }
}

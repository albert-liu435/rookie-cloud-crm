package com.rookie.bigdata.mybatis.service.impl;

import com.rookie.bigdata.common.MbUser;
import com.rookie.bigdata.mybatis.service.MbUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @Class MbUserServiceImplTest
 * @Description
 * @Author rookie
 * @Date 2024/10/11 17:40
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
//@AutoConfigureMockMvc
@Slf4j
class MbUserServiceImplTest {

    @Autowired
    private MbUserService mbUserService;

    @Test
    void getMbUserByParams() {
        MbUser nba = mbUserService.getMbUserByParams("123", "NBA");
        log.info("查询出的会员信息为:{}",nba);
    }
}

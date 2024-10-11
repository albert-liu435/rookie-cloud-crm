package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.MbUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * @Class MbUserMapperTest
 * @Description
 * @Author rookie
 * @Date 2024/10/11 16:47
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
//@AutoConfigureMockMvc
@Slf4j
class MbUserMapperTest {

    @Autowired
    private MbUserMapper mbUserMapper;

    @Test
    void getAll() {
        List<MbUser> all = mbUserMapper.getAll();
        for (MbUser mbUser : all) {
            log.info("获取的用户信息为：{}", mbUser.toString());
        }
    }
}

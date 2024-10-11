package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.MbFans;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * @Class FansMapperTest
 * @Description
 * @Author rookie
 * @Date 2024/10/8 17:48
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
//@AutoConfigureMockMvc
@Slf4j
class MbFansMapperTest {

    @Autowired
    private MbFansMapper fansMapper;


    @Test
    void testGetAll() {
        List<MbFans> all = fansMapper.getAll();
        log.info("获取的数据条数：{}",all.size());

    }

}

package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.CgApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * @Class AppMapperTest
 * @Description
 * @Author rookie
 * @Date 2024/10/10 11:48
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
//@AutoConfigureMockMvc
@Slf4j
class CgAppMapperTest {

    @Autowired
    private CgAppMapper appMapper;

    @Test
    void getAll() {

        List<CgApp> all = appMapper.getAll();
        log.info("获取的数据条数：{}", all.size());
    }

    @Test
    void getAppByType() {
    }
}

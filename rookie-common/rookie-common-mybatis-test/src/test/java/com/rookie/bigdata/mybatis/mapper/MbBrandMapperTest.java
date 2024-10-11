package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.MbBrand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * @Class MbBrandMapperTest
 * @Description
 * @Author rookie
 * @Date 2024/10/11 17:19
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
//@AutoConfigureMockMvc
@Slf4j
class MbBrandMapperTest {

    @Autowired
    private MbBrandMapper brandMapper;

    @Test
    void getAll() {
        List<MbBrand> all = brandMapper.getAll();
        for (MbBrand mbBrand : all) {
            log.info("获取所有的品牌信息: {}",mbBrand.toString());
        }
    }

    @Test
    void getBrandByCode() {

        MbBrand nba = brandMapper.getBrandByCode("NBA");
        log.info("获取所有的品牌信息: {}",nba.toString());
    }
}

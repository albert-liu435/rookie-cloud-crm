package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.MbLevel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * @Class MbLevelMapperTest
 * @Description
 * @Author rookie
 * @Date 2024/10/11 17:03
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
//@AutoConfigureMockMvc
@Slf4j
class MbLevelMapperTest {

    @Autowired
    private MbLevelMapper mbLevelMapper;

    @Test
    void getAll() {

        List<MbLevel> all = mbLevelMapper.getAll();
        for (MbLevel mbLevel : all) {
            log.info("获取所有的等级:{}", mbLevel);
        }

    }


    @Test
    void getLevelByBrand(){
        MbLevel mbLevel=new MbLevel();
        mbLevel.setLevelNo("1");
        mbLevel.setBrandCode("NBA");
        MbLevel levelByBrand = mbLevelMapper.getLevelByBrand(mbLevel);
        log.info("获取的等级信息：{}",levelByBrand.toString());

    }

}

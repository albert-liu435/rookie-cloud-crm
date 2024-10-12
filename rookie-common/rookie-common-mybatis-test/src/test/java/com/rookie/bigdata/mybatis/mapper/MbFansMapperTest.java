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
        log.info("获取的数据条数：{}", all.size());

    }

    @Test
    void getOneMbFansByMbFans() {
        MbFans mbFans = new MbFans();
//        mbFans.setUserId(1);
        mbFans.setOpenId("18200012120");
        MbFans oneMbFansByMbFans = fansMapper.getOneMbFansByMbFans(mbFans);
        log.info("获取的数据为: {}", oneMbFansByMbFans.toString());

    }

    @Test
    void insertMbFans() {
        MbFans mbFans = new MbFans();
        mbFans.setPhone("abcd");
        fansMapper.insertMbFans(mbFans);
        log.info("插入的数据为：{}", mbFans.toString());
    }


}

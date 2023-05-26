package com.rookie.bigdata.service.taobao.impl;

import com.rookie.bigdata.service.taobao.TaoBaoOrderOuidService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class TaoBaoSpiServiceImplTest
 * @Description 测试类
 * @Author rookie
 * @Date 2023/5/26 10:29
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
class TaoBaoSpiServiceImplTest {

    @Autowired
    private TaoBaoSpiServiceImpl taoBaoSpiService;

    @Test
    void loadTaoBaoSPIConfigStorages() {

        Map<String, TaoBaoOrderOuidService> mapOrderOuidTaoBaoService = taoBaoSpiService.getMapOrderOuidTaoBaoService();

        for (String s : mapOrderOuidTaoBaoService.keySet()) {
            System.out.println(s);
        }


    }
}
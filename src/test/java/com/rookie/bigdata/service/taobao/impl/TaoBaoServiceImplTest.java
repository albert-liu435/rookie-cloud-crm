package com.rookie.bigdata.service.taobao.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class TaoBaoServiceImplTest
 * @Description
 * @Author rookie
 * @Date 2023/5/26 10:42
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
class TaoBaoServiceImplTest {

    @Autowired
    private TaoBaoServiceImpl taoBaoService;

    @Test
    void queryCrmOrder() throws Exception{

        String abc = taoBaoService.queryCrmOrder("abc", 123L);

    }
}
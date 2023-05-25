package com.rookie.bigdata.mapper;

import com.rookie.bigdata.entity.taobao.TaoBaoSPI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class TaoBaoSpiMpperTest
 * @Description 测试类
 * @Author rookie
 * @Date 2023/5/25 17:58
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
class TaoBaoSpiMpperTest {

    @Autowired
    private TaoBaoSpiMpper taoBaoSpiMpper;

    @Test
    void selectAll() {

        for (TaoBaoSPI taoBaoSPI : taoBaoSpiMpper.selectAll()) {

            System.out.println(taoBaoSPI.getServiceUrl());
        }

    }
}
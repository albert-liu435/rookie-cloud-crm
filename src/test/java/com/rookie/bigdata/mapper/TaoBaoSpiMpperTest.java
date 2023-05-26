package com.rookie.bigdata.mapper;

import com.rookie.bigdata.entity.taobao.TaoBaoSPI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

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
    void selectByAppType() {

        List<TaoBaoSPI> taoBaoSPIS = taoBaoSpiMpper.selectByAppType("order");

        System.out.println("测试"+taoBaoSPIS.size());

        for (TaoBaoSPI taoBaoSPI : taoBaoSPIS) {

            System.out.println(taoBaoSPI);
        }

    }
}
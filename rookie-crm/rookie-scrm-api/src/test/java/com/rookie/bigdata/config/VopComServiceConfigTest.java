package com.rookie.bigdata.config;

import com.rookie.bigdata.service.VopClientService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class VopComServiceConfigTest
 * @Description
 * @Author rookie
 * @Date 2024/10/11 9:42
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
//@AutoConfigureMockMvc
@Slf4j
class VopComServiceConfigTest {

    @Test
    void getVopClientService() {

        VopClientService nba = VopComServiceConfig.getVopClientService("NBA");

        log.info(nba.toString());


    }
}

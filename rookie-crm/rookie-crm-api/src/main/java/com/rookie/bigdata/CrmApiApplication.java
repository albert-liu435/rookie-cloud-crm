package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Class CrmApiApplication
 * @Description
 * @Author rookie
 * @Date 2024/9/26 15:17
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CrmApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApiApplication.class, args);
    }
}

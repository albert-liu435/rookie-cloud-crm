package com.rookie.bigdata.mybatis.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Class MybatisConfig
 * @Description
 * @Author rookie
 * @Date 2024/10/8 16:40
 * @Version 1.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.rookie.bigdata.mybatis.mapper")
public class MybatisConfig {
}

package com.rookie.bigdata.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class SPIVopController
 * @Description
 * @Author rookie
 * @Date 2024/10/10 11:11
 * @Version 1.0
 */
@RestController
@RequestMapping("spi/vop")
@Slf4j
public class SPIVopController {



    private final Gson gson = new GsonBuilder()
            // .setPrettyPrinting()
            .disableHtmlEscaping()
            .create();




}

package com.rookie.bigdata.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rookie.bigdata.domain.vop.VopBindQueryResponse;
import com.rookie.bigdata.domain.vop.VopMember;
import com.rookie.bigdata.enums.SPIVopEnum;
import com.rookie.bigdata.service.SPIVopServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


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


    @Autowired
    private SPIVopServer spiVopServer;


    private final Gson gson = new GsonBuilder()
            // .setPrettyPrinting()
            .disableHtmlEscaping()
            .create();


    /**
     * 绑定查询
     *
     * @param params
     * @return
     */
    @RequestMapping("/queryBind")
    public String vopQueryBind(@RequestParam Map<String, Object> params) {

        VopBindQueryResponse<VopMember> vopBindQueryResponse = new VopBindQueryResponse<VopMember>();
        vopBindQueryResponse.setCode(SPIVopEnum.E99.getCode());
        vopBindQueryResponse.setMessage(SPIVopEnum.E99.getMsg());
        try {
            vopBindQueryResponse = spiVopServer.vopQueryBind(params);
        } catch (Exception e) {
            //系统抛出异常
            log.error("vop query queryBind {}", e.getMessage());
        }
        return gson.toJson(vopBindQueryResponse);

//        return vopBindQueryResponse;
    }


}

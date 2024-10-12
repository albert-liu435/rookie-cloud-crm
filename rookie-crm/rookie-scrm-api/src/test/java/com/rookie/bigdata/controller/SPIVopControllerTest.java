package com.rookie.bigdata.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.rookie.bigdata.config.VopComServiceConfig;
import com.rookie.bigdata.service.VopClientService;
import com.rookie.bigdata.util.VopAesEncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Class SPIVopControllerTest
 * @Description
 * @Author rookie
 * @Date 2024/10/10 17:40
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@Slf4j
class SPIVopControllerTest {


//    private static final String NAME = "Tom";

//    @Test
//    void getHello(@Autowired MockMvc mvc) throws Exception {
//        // 模拟
//        MvcResult mvcResult = mvc.perform(
//                        get("/" + NAME)
//                                .content("hello".getBytes(StandardCharsets.UTF_8))
//                )
//
//                .andExpect(status().isOk())
////                .andExpect(content().string("Hello " + NAME))
//                .andReturn();
//
//
////        System.out.println(mvcResult.getResponse());
//        log.info("响应内容：{}", mvcResult.getResponse().getContentAsString());
//
//    }

    @Autowired
    private MockMvc mvc;


    public static String phone = "18200000001";

    public static String openId = "AAF1uiz0AF7NN7CzqaGpcyw4abc";

    public static String brandIdentify = "NBA";



    @Test
    void vopQueryBind(/*@Autowired MockMvc mvc*/) throws Exception {

        VopClientService vopClientService = VopComServiceConfig.getVopClientService(brandIdentify);
//        vopClientService.

//        vopTokenService = VopComServiceConfig.getVopTokenService(brandIdentify);
        String appkey = vopClientService.getAppKey();
        String appSercet = vopClientService.getAppSecret();
        String mix_mobile = VopAesEncryptUtils.encrypt(phone, appkey);

        Map<String, Object> params = new HashMap<>();
        params.put("brand_identify", brandIdentify);
        params.put("open_id", openId);
        params.put("timestamp", System.currentTimeMillis());
        params.put("mix_mobile", mix_mobile);

        String content = appSercet + MapUtil.sortJoin(params, "&", "=", true, null) + appSercet;

        String md5Str32Upper = SecureUtil.md5(content).toUpperCase();
        params.put("sign", md5Str32Upper);

        String param = MapUtil.sortJoin(params, "&", "=", true, null);

        String getUrl = "/spi/vop/queryBind?" + param;
        log.info("请求的url地址为：{}", getUrl);

        //向API发起请求
        MvcResult result = mvc.perform(get(getUrl)
                                //设置contentType参数
                                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        //设置请求体参数
//                        .content(new Gson().toJson(inParam))
                )
                //模拟向testRest发送get请求
                .andExpect(status().isOk())
                //返回执行请求的结果
                .andReturn();

        log.info(result.getResponse().getContentAsString());




//        String uri = "spi/vop/queryBind";
//
//        // 模拟
//        MvcResult mvcResult = mvc.perform(
//                        get("/" + uri)
////                                .content("hello".getBytes(StandardCharsets.UTF_8))
//                )
//
//                .andExpect(status().isOk())
////                .andExpect(content().string("Hello " + NAME))
//                .andReturn();
//
//
////        System.out.println(mvcResult.getResponse());
//        log.info("响应内容：{}", mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

}

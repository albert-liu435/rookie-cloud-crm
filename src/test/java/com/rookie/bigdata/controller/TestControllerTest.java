package com.rookie.bigdata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class TestControllerTest
 * @Description 测试类
 * @Author rookie
 * @Date 2023/5/25 16:49
 * @Version 1.0
 */
@SpringBootTest
@AutoConfigureMockMvc
//@EnableWebMvc
@ActiveProfiles("dev")
class TestControllerTest {


    @Autowired
    private MockMvc mvc;


    @Test
    void test01() throws Exception{

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/test/get")
                        // 这个“Accept” 头属性能被浏览器用来指定响应的media 类型，表示自己可以接受的类型。
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .header("platform","crm")
//                        .header("timestamp",now)
//                        .header("sign",newToken)
//                        .content(bindJson)
                )
//                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        MockHttpServletResponse response = result.getResponse();
        String contentAsString = response.getContentAsString();
        System.out.println(contentAsString);
        System.out.println(result.getResponse().getContentAsString());

    }


//    @Test
//    void ouidGetFromAliToken() throws Exception{
//
//        String now = DateUtil.now();
//        System.out.println(now);
//
//
//        CrmOrder crmRequest=new CrmOrder();
//        crmRequest.setShopCode("JZZW");
//        crmRequest.setTid(2991241550836070928L);
//
//
//        String bindJson = gson.toJson(crmRequest);
//
////        String bindJson="{\"shopCode\":\"VZZX\",\"orderNo\":2836874521896159621}";
////        String bindJson=" {\"shopCode\":\"abcd\",\"orderNo\":\"abcd\"}";
//        System.out.println(bindJson);
//
//
//        String str = "7AecVeZKZcc7bNZ9" + now + "crm";
//
//        String newToken = SecureUtil.md5(str);
//
//        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/ouid/get")
//                        // 这个“Accept” 头属性能被浏览器用来指定响应的media 类型，表示自己可以接受的类型。
//                        .accept(MediaType.APPLICATION_JSON_UTF8)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .header("platform","crm")
//                        .header("timestamp",now)
//                        .header("sign",newToken)
//                        .content(bindJson))
////                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        String contentAsString = response.getContentAsString();
//        System.out.println(contentAsString);
//        System.out.println(result.getResponse().getContentAsString());
//
//    }
//
//
//    @Test
//    void ouidGetFromAli() throws Exception{
//
//
//        String now = DateUtil.now();
//        System.out.println(now);
//
//
//        CrmOrder crmRequest=new CrmOrder();
////        crmRequest.setShopCode("JZZW");
////        crmRequest.setTid(2991241550836070928L);
////        crmRequest.setShopCode("OZZY");
////        crmRequest.setTid(2991364021211034679L);
////        crmRequest.setShopCode("SZZY");
////        crmRequest.setTid(1722976753930945085L);
//
////        crmRequest.setShopCode("VZZX");
////        crmRequest.setTid(2987497260868393310L);
//
////        crmRequest.setShopCode("FZZV");
////        crmRequest.setTid(2987894773379883512L);
//
////        crmRequest.setShopCode("OZZF");
////        crmRequest.setTid(2989222663615476749L);
//
////        crmRequest.setShopCode("VZZL");
////        crmRequest.setTid(1723074708666018479L);
//
////        crmRequest.setShopCode("SZZE");
////        crmRequest.setTid(2987929620199640125L);
//
////        crmRequest.setShopCode("OZZK");
////        crmRequest.setTid(1724130733592018783L);
//
////        crmRequest.setShopCode("JZZO");
////        crmRequest.setTid(2990813185342569723L);
//
//        crmRequest.setShopCode("VZZI");
//        crmRequest.setTid(2993279509086960918L);
//
////        crmRequest.setShopCode("RZ01");
////        crmRequest.setTid(2994733333566168020L);
//
//        String bindJson = gson.toJson(crmRequest);
//
////        String bindJson="{\"shopCode\":\"VZZX\",\"orderNo\":2836874521896159621}";
////        String bindJson=" {\"shopCode\":\"abcd\",\"orderNo\":\"abcd\"}";
//        System.out.println(bindJson);
//
//
//        String str = "7AecVeZKZcc7bNZ9" + now + "crm";
//
//        String newToken = SecureUtil.md5(str);
//
//        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/ouid/get")
//                        // 这个“Accept” 头属性能被浏览器用来指定响应的media 类型，表示自己可以接受的类型。
//                        .accept(MediaType.APPLICATION_JSON_UTF8)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .header("platform","crm")
//                        .header("timestamp",now)
//                        .header("sign",newToken)
//                        .content(bindJson))
////                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//        String contentAsString = response.getContentAsString();
//        System.out.println(contentAsString);
//        System.out.println(result.getResponse().getContentAsString());
//
//
//
//    }
//
//
//
//    @Test
//    void ouidGetFromAliHttp() throws Exception{
//
//
//        String now = DateUtil.now();
//        System.out.println(now);
//
//
//        CrmOrder crmRequest=new CrmOrder();
////        crmRequest.setShopCode("JZZW");
////        crmRequest.setTid(2991241550836070928L);
////        crmRequest.setShopCode("OZZY");
////        crmRequest.setTid(2991364021211034679L);
////        crmRequest.setShopCode("SZZY");
////        crmRequest.setTid(1722976753930945085L);
//
////        crmRequest.setShopCode("VZZX");
////        crmRequest.setTid(2987497260868393310L);
//
////        crmRequest.setShopCode("FZZV");
////        crmRequest.setTid(2987894773379883512L);
//
////        crmRequest.setShopCode("OZZF");
////        crmRequest.setTid(2989222663615476749L);
//
////        crmRequest.setShopCode("VZZL");
////        crmRequest.setTid(1723074708666018479L);
//
////        crmRequest.setShopCode("SZZE");
////        crmRequest.setTid(2987929620199640125L);
//
////        crmRequest.setShopCode("OZZK");
////        crmRequest.setTid(1724130733592018783L);
//
////        crmRequest.setShopCode("JZZO");
////        crmRequest.setTid(2990813185342569723L);
//
//        crmRequest.setShopCode("VZZI");
//        crmRequest.setTid(2993279509086960918L);
//
////        crmRequest.setShopCode("RZ01");
////        crmRequest.setTid(2994733333566168020L);
//
//        String bindJson = gson.toJson(crmRequest);
//
////        String bindJson="{\"shopCode\":\"VZZX\",\"orderNo\":2836874521896159621}";
////        String bindJson=" {\"shopCode\":\"abcd\",\"orderNo\":\"abcd\"}";
//        System.out.println(bindJson);
//
//
//        String str = "7AecVeZKZcc7bNZ9" + now + "crm";
//
//        String newToken = SecureUtil.md5(str);
//
//
//        Map<String, String> headerMap = new HashMap<>();
//
//        headerMap.put("platform","crm");
//        headerMap.put("timestamp",now);
//        headerMap.put("sign",newToken);
//        headerMap.put("Content-Type", "application/json");
//
//        String result = CsHttpRequestUtil.httpRequest("http://istoremember.bestseller.com.cn/alicrm/ouid/get", bindJson, "POST", headerMap);
//
//
//
//        System.out.println(result);
//
////        MockHttpServletResponse response = result.getResponse();
////        String contentAsString = response.getContentAsString();
////        System.out.println(contentAsString);
////        System.out.println(result.getResponse().getContentAsString());
//
//
//
//    }

}
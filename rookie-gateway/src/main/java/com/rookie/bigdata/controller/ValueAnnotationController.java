//package com.rookie.bigdata.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Class ValueAnnotationController
// * @Description
// * @Author rookie
// * @Date 2024/10/9 18:09
// * @Version 1.0
// */
//@RestController
//@RequestMapping("/nacos/annotation")
//@RefreshScope
//public class ValueAnnotationController {
//
//    @Value("${spring.cloud.nacos.config.serverAddr:}")
//    private String serverAddr;
//
//    @Value("${spring.cloud.nacos.config.prefix:}")
//    private String prefix;
//
//    @Value("${mysql.port:}")
//    private String group;
//
//    @Value("${spring.cloud.nacos.config.namespaceac:}")
//    private String namespace;
//
//    @GetMapping
//    public Map<String, String> getConfigInfo() {
//        Map<String, String> result = new HashMap<>(4);
//        result.put("serverAddr", serverAddr);
//        result.put("prefix", prefix);
//        result.put("group", group);
//        result.put("namespace", namespace);
//        return result;
//    }
//}

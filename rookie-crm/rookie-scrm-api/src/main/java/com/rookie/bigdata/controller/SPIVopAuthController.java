package com.rookie.bigdata.controller;

import com.rookie.bigdata.service.AuthTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Class SPIVopAuthController
 * @Description https://vop.vip.com/doccenter/viewdoc/33
 * @Author rookie
 * @Date 2024/10/10 11:25
 * @Version 1.0
 */
@RestController
@RequestMapping("spi/vop")
@Slf4j
public class SPIVopAuthController {


    @Autowired
    private AuthTokenService authTokenService;


    //TODO 接受code,并换取相关的token,最终需要进行发送邮件通知,进行应用的重启，也可以通过nacos的方式，将新的token相关信息配置到nacos中，通过更新配置文件来达到目的



//    public interface InitializingBean {
//
//        void afterPropertiesSet() throws Exception;
//
//    }





    @RequestMapping("/resource/{appid}")
    public String endpointApp(@PathVariable(value = "appid") String appid) {
        log.info("appid:{}", appid);
        return "endpoint";
    }


    @GetMapping("/greet")
    public String greet(@RequestParam(name = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }


}

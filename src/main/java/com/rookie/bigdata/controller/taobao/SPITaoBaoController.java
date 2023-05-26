package com.rookie.bigdata.controller.taobao;

import com.rookie.bigdata.controller.TestController;
import com.rookie.bigdata.entity.taobao.TaoBaoBindQueryIn;
import com.rookie.bigdata.entity.taobao.TaoBaoBindQueryOut;
import com.rookie.bigdata.service.taobao.TaoBaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class SPITaoBaoController
 * @Description 淘宝controller, 用于接受淘宝平台的接口调用
 * @Author rookie
 * @Date 2023/5/26 11:05
 * @Version 1.0
 */
@RestController
@RequestMapping("spi")
public class SPITaoBaoController {

    public static final Logger logger = LoggerFactory.getLogger(SPITaoBaoController.class);


    @Autowired
    private TaoBaoService taoBaoService;


    //https://open.taobao.com/docV3.htm?spm=a219a.7386797.0.0.1ee8669aOT19s3&source=search&docId=108453&docType=1
//接口验签（可选）
//程序逻辑上的处理是在http入口处先做签名校验，保证每个SPI接口调用方只能是淘宝，保证接口的安全性。不做校验亦可，不做强制要求
//引入SpiUtil.java包(淘宝开放平台sdk下载，com.taobao.api.internal.spi.SpiUtils)，加密串为相关应用的AppSecret（非沙箱AppSecret），签名的测试可在SPI开发中测试。每个SPI接口都要加上如下逻辑
//java示例代码：
//
////IOUtils可参考使用org.apache.commons.io.IOUtils里的
//
//String body = IOUtils.toString(request.getInputStream(), "utf-8");
//
///**此方法的逻辑是：
//
//* ISV根据SPI调用的内容(body,post等参数)和秘钥(appsecrt)进行MD5计算，
//
//* 计算出的sign的值跟淘宝用同样的加密方式（SPI调用的内容(body,post等参数)和秘钥(appsecrt)进行MD5计算）计算出来的结果进行比较。
//
//* 比较结果如果是True说明双方都有共同的秘钥(appsecrt)，说明调用可信赖.appsecrt注意保密。
//
//* 淘宝计算出的sign值在SPI调用的URL里有。类似http://gw.api.taobao.com/router/rest?sign=5CEC9D0FE251B1CA0DDAE4C37F2421F1&timestamp=2017-10-23+12%3A06%3A35
//
//* SpiUtils 在淘宝开放平台 SDK里下载 com.taobao.api.internal.spi.SpiUtils
//
//**/
//
//if(!SpiUtils.checkSign4TextRequest(request, body, "此字符串要修改成AppSecret")) {
//
////拒绝访问，非来自淘宝的请求,根据实际情况实现
//
//throw new RuntimeException("非来自淘宝的请求");
//
//}

    /**
     * 淘宝平台绑定查询接口
     *
     * @param taoBaoBindQuery
     * @return
     */
    @RequestMapping(value = "/bindquery")
    public TaoBaoBindQueryOut bindqueryOnly(@RequestBody TaoBaoBindQueryIn taoBaoBindQuery) {
//        logger.info("淘宝绑定查询请求消息:{}", gson.toJson(taoBaoBindQuery));

        TaoBaoBindQueryOut bindQueryResponse = taoBaoService.bindQuery(taoBaoBindQuery);
//        logger.info("淘宝绑定查询请求返回消息:{}", gson.toJson(bindQueryResponse));

//        return bindQueryResponse;

        return bindQueryResponse;
    }


}

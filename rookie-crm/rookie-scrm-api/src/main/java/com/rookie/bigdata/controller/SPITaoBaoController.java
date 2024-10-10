package com.rookie.bigdata.controller;

/*import com.google.gson.Gson;
import com.google.gson.GsonBuilder;*/
import com.rookie.bigdata.domain.taobao.TaoBaoBindQueryRequest;
import com.rookie.bigdata.domain.taobao.TaoBaoBindQueryResponse;
import com.rookie.bigdata.service.SPITaoBaoServer;
import com.rookie.bigdata.web.util.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class SPITaoBaoController
 * @Description https://open.taobao.com/docV3.htm?spm=a219a.7386797.0.0.1ee8669aOT19s3&source=search&docId=108453&docType=1
 * https://www.yuque.com/alibabacem/crmoperation/pbw0bd?spm=a219a.15212433.0.0.1751669abdy0bh
 * @Author rookie
 * @Date 2024/9/26 15:44
 * @Version 1.0
 */
@RestController
@RequestMapping("spi/taobao")
@Slf4j
public class SPITaoBaoController {


/*
    private final Gson gson = new GsonBuilder()
            // .setPrettyPrinting()
            .disableHtmlEscaping()
            .create();
*/

    @Autowired
    private SPITaoBaoServer taoBaoServer;


    //激活接口

    //绑定查询
    //{\"extend\":\"{\\\"flightJoinTime\\\":\\\"2024-10-09 01:07:02\\\",\\\"flightMode\\\":\\\"1\\\",\\\"level\\\":1}\",\"seller_name\":\"nationalgeographic户外店\",\"open_id\":\"AAGUAdL9AOFemXQEHNnOhyyA\",\"ouid\":\"AAG2Aa1nAAAYIPoAAVyriDOu\",\"mix_mobile\":\"bb00b08174cd00b55ef948f04cd808e7\"}"

    @RequestMapping(value = "/bindquery")
    public TaoBaoBindQueryResponse bindquery(@RequestBody TaoBaoBindQueryRequest taoBaoBindQuery) {
        //获取请求体消息
        String jsonBody = RequestUtils.getJsonBody();

//        log.info("淘宝new绑定查询请求消息:{}", gson.toJson(jsonBody));
        // 进行绑定查询

        TaoBaoBindQueryResponse bindQueryResponse = taoBaoServer.bindquery(taoBaoBindQuery);
//        log.info("淘宝绑定查询请求返回消息:{}", gson.toJson(bindQueryResponse));

        return bindQueryResponse;
    }


    //注册

    //查询

    //绑定


    //品牌会员通解绑


}

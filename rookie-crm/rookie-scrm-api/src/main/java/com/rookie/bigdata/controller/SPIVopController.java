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


    /**
     * 绑定查询
     *
     * @param params
     * @return
     */
//    @RequestMapping("/queryBind")
//    public String vopQueryBind(@RequestParam Map<String, Object> params) {
//
//        QueryBindOut queryBindOut = new QueryBindOut();
//        queryBindOut.setCode(VopMemEnum.MEM_E99.getCode());
//        queryBindOut.setMessage(VopMemEnum.MEM_E99.getMsg());
//        QueryBindOut.Content content = new QueryBindOut.Content();
//        content.setBind_able(false);
//        queryBindOut.setContent(content);
//
//        try {
//            queryBindOut = vopService.vopQueryBind(params);
//        } catch (Exception e) {
//            //系统抛出异常
//            logger.error("vop query queryBind {}", e.getMessage());
//        }
//
//        return ngson.toJson(queryBindOut);
//
//    }


}

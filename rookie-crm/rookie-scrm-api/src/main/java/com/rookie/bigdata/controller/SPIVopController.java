package com.rookie.bigdata.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rookie.bigdata.domain.vop.VopSPIResponse;
import com.rookie.bigdata.domain.vop.VopMember;
import com.rookie.bigdata.enums.SPIVopEnum;
import com.rookie.bigdata.service.SPIVopServer;
import com.rookie.bigdata.web.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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

        VopSPIResponse<VopMember> vopBindQueryResponse = new VopSPIResponse<VopMember>();
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

    /**
     * 绑定
     *
     * @param params
     * @return
     */
    @RequestMapping("/bind")
    public String vopBind(@RequestParam Map<String, Object> params) {
        VopSPIResponse<VopMember> vopBindQueryResponse = new VopSPIResponse<VopMember>();
        vopBindQueryResponse.setCode(SPIVopEnum.E99.getCode());
        vopBindQueryResponse.setMessage(SPIVopEnum.E99.getMsg());


        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        String entity = RequestUtils.getJsonBody(request);

        try {
            vopBindQueryResponse = spiVopServer.vopBind(params,entity);
        } catch (Exception e) {
            //系统抛出异常
            log.error("vop bind {}", e.getMessage());
        }

        return gson.toJson(vopBindQueryResponse);

    }

    /**
     * 解绑
     *
     * @param params
     * @return
     */
    @RequestMapping("/unbind")
    public String vopUnBind(@RequestParam Map<String, Object> params/*, @RequestBody VopMemRequest vopMemRequest*/) {
        VopSPIResponse<VopMember> vopBindQueryResponse = new VopSPIResponse<VopMember>();
        vopBindQueryResponse.setCode(SPIVopEnum.E99.getCode());
        vopBindQueryResponse.setMessage(SPIVopEnum.E99.getMsg());


        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        String entity = RequestUtils.getJsonBody(request);

        try {
            vopBindQueryResponse = spiVopServer.vopUnBind(params, entity);
        } catch (Exception e) {
            //系统抛出异常
            log.error("vop unbind {}", e.getMessage());
        }

        return gson.toJson(vopBindQueryResponse);

    }

    /**
     * 注册
     *
     * @param params
     * @return
     */
    @RequestMapping("/register")
    public String vopRegister(@RequestParam Map<String, Object> params) {
        VopSPIResponse<VopMember> vopBindQueryResponse = new VopSPIResponse<VopMember>();
        vopBindQueryResponse.setCode(SPIVopEnum.E99.getCode());
        vopBindQueryResponse.setMessage(SPIVopEnum.E99.getMsg());


        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        String entity = RequestUtils.getJsonBody(request);

        try {
            vopBindQueryResponse = spiVopServer.vopRegister(params, entity);
        } catch (Exception e) {
            //系统抛出异常
            log.error("vop query register {}", e.getMessage());
        }

        return gson.toJson(vopBindQueryResponse);

    }


    /**
     * 会员信息查询
     *
     * @param params
     * @return
     */
    @RequestMapping("/queryMemberInfo")
    public String vopQueryMemberInfo(@RequestParam Map<String, Object> params) {
        VopSPIResponse vopBindQueryResponse = new VopSPIResponse();
        vopBindQueryResponse.setCode(SPIVopEnum.E99.getCode());
        vopBindQueryResponse.setMessage(SPIVopEnum.E99.getMsg());


//        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attrs.getRequest();
//        String entity = RequestUtils.getJsonBody(request);


        try {
            vopBindQueryResponse = spiVopServer.vopQueryMemberInfo(params);
        } catch (Exception e) {
            //系统抛出异常
            log.error("vop query queryMemberInfo {}", e.getMessage());
        }

        return gson.toJson(vopBindQueryResponse);

    }



}

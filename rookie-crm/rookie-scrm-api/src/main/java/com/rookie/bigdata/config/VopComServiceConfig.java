package com.rookie.bigdata.config;

import com.rookie.bigdata.common.CgApp;
import com.rookie.bigdata.mybatis.service.CgAppService;
import com.rookie.bigdata.service.VopClientService;
import com.rookie.bigdata.service.impl.VopClientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Class VopComServiceConfig
 * @Description
 * @Author rookie
 * @Date 2024/10/10 15:50
 * @Version 1.0
 */
@Configuration
@Slf4j
public class VopComServiceConfig implements InitializingBean {


    @Autowired
    private CgAppService appService;

    private static Map<String, VopClientService> mapVopClientService;


    @Override
    public void afterPropertiesSet() throws Exception {

        mapVopClientService = new HashMap<>();
        List<CgApp> allApp = appService.getAllAppByType("1");
        for (CgApp app : allApp) {
            //TODO 根据app信息创建VopClientService对象

            VopClientService vopClientService = new VopClientServiceImpl(app.getAppKey(), app.getAppSecret(), app.getAppToken(), app.getBrand());

            mapVopClientService.put(app.getBrand(), vopClientService);
        }


    }

    public static VopClientService getVopClientService(String brand) {
        VopClientService clientService = mapVopClientService.get(brand);
        if (clientService == null) {
            throw new IllegalArgumentException(String.format("未找到对应brand=[%s]的配置，请核实！", brand));
        }
        return clientService;
    }


}

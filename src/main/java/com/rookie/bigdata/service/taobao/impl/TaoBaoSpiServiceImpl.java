package com.rookie.bigdata.service.taobao.impl;

import com.rookie.bigdata.controller.TestController;
import com.rookie.bigdata.entity.taobao.TaoBaoSPI;
import com.rookie.bigdata.mapper.TaoBaoSpiMpper;
import com.rookie.bigdata.service.taobao.TaoBaoOrderOuidService;
import com.rookie.bigdata.service.taobao.TaoBaoSpiService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Class TaoBaoSpiServiceImpl
 * @Description TaoBaoSpiService
 * @Author rookie
 * @Date 2023/5/26 9:58
 * @Version 1.0
 */

@Service
public class TaoBaoSpiServiceImpl implements TaoBaoSpiService {

    public static final Logger logger = LoggerFactory.getLogger(TaoBaoSpiServiceImpl.class);


    private  Map<String, TaoBaoOrderOuidService> mapOrderOuidTaoBaoService = new HashMap<>();

    @Autowired
    private TaoBaoSpiMpper taoBaoSpiMpper;


    @Override
    public  Map<String, TaoBaoOrderOuidService> getMapOrderOuidTaoBaoService() {
        return mapOrderOuidTaoBaoService;
    }


//    public  void setMapOrderOuidTaoBaoService(Map<String, TaoBaoOrderOuidService> mapOrderOuidTaoBaoService) {
//        mapOrderOuidTaoBaoService = mapOrderOuidTaoBaoService;
//    }


    @PostConstruct
    public void loadTaoBaoSPIConfigStorages() {
        logger.info("加载淘宝SPI配置...");

        // 首先查询SPI相关的配置信息
        List<TaoBaoSPI> order = taoBaoSpiMpper.selectByAppType("order");

        // 将SPI相关的信息放入map中
        for (TaoBaoSPI taoBaoSPI : order) {
            TaoBaoOrderOuidService client = new TaoBaoOrderOuidServiceImpl(taoBaoSPI.getServerUrl(), taoBaoSPI.getAppKey(), taoBaoSPI.getAppSecret(), taoBaoSPI.getSessionKey());
            mapOrderOuidTaoBaoService.put(taoBaoSPI.getShopCode(), client);

        }


    }

}

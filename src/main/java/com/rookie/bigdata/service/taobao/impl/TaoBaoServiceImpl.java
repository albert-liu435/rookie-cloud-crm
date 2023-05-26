package com.rookie.bigdata.service.taobao.impl;

import com.rookie.bigdata.entity.taobao.TaoBaoBindQueryIn;
import com.rookie.bigdata.entity.taobao.TaoBaoBindQueryOut;
import com.rookie.bigdata.service.taobao.TaoBaoOrderOuidService;
import com.rookie.bigdata.service.taobao.TaoBaoService;
import com.rookie.bigdata.service.taobao.TaoBaoSpiService;
import com.taobao.api.ApiException;
import com.taobao.api.request.TradeSimpleGetRequest;
import com.taobao.api.response.TradeSimpleGetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Class TaoBaoServiceImpl
 * @Description TaoBaoServiceImpl
 * @Author rookie
 * @Date 2023/5/26 10:34
 * @Version 1.0
 */
@Service
public class TaoBaoServiceImpl implements TaoBaoService {


    public static final Logger logger = LoggerFactory.getLogger(TaoBaoServiceImpl.class);


    @Autowired
    private TaoBaoSpiService taoBaoSpiService;


    @Override
    public String queryCrmOrder(String shopCode, Long tid) throws ApiException {

        Map<String, TaoBaoOrderOuidService> mapOrderOuidTaoBaoService = taoBaoSpiService.getMapOrderOuidTaoBaoService();
        TaoBaoOrderOuidService taoBaoOrderOuidService = mapOrderOuidTaoBaoService.get(shopCode);

        TradeSimpleGetRequest req = new TradeSimpleGetRequest();
//        req.setFields("tid,type,status,payment,orders,promotion_details");
        req.setFields("tid");
        req.setTid(tid);
        TradeSimpleGetResponse execute = taoBaoOrderOuidService.execute(req);
        logger.info("返回数据为：" + execute.getBody());


        return execute.getBody();
    }

    @Override
    public TaoBaoBindQueryOut bindQuery(TaoBaoBindQueryIn taoBaoBindQuery) {
        //TODO 查询粉丝表，看看是否有淘宝的粉丝信息

        return null;
    }
}

package com.rookie.bigdata.service.taobao.impl;

import com.rookie.bigdata.entity.crm.Fans;
import com.rookie.bigdata.entity.taobao.TaoBaoBindQueryIn;
import com.rookie.bigdata.entity.taobao.TaoBaoBindQueryOut;
import com.rookie.bigdata.mapper.FansMapper;
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

import java.util.HashMap;
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


    @Autowired
    private FansMapper fansMapper;


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

        TaoBaoBindQueryOut taoBaoBindQueryOut=new TaoBaoBindQueryOut();

        Map<String, String> map = new HashMap<>();
        map.put("type", "1");
        map.put("ouid", taoBaoBindQuery.getOuid());
        map.put("phone", taoBaoBindQuery.getMobile());

        // 查询粉丝表，看看是否有淘宝的粉丝信息

        Fans fans = fansMapper.selectFansByMap(map);
        //判断粉丝是否存在，如果不存在则返回不存在,如果存在的话就查询会员,会员必定也是存在的
        //必填 以下为不能绑定的代码，如果可绑定返回SUC(需返回明文手机号)。 E01:会员不存在 E02:会员已被绑定 E04:会员不存在，可注册 E05:系统繁忙或异常，可重试 其他原因可传F01，F02等， 系统统一识别为会员不存在
        //E04会员信息不存在，可注册
        if (null == fans) {
            taoBaoBindQueryOut.setBindCode("E04");
            taoBaoBindQueryOut.setBindable(false);

            return taoBaoBindQueryOut;
        }

        //查询会员信息,E02:会员已被绑定




        return null;
    }
}

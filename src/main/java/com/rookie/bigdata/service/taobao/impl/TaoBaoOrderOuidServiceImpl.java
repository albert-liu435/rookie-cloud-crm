package com.rookie.bigdata.service.taobao.impl;

import com.rookie.bigdata.service.taobao.TaoBaoOrderOuidService;
import com.taobao.api.*;

/**
 * @Class TaoBaoOrderOuidService
 * @Description 实现类
 * @Author rookie
 * @Date 2023/5/26 9:56
 * @Version 1.0
 */

//@Service
public class TaoBaoOrderOuidServiceImpl implements TaoBaoOrderOuidService {

    private String sessionKey;

    private TaobaoClient taobaoClient;

    public TaoBaoOrderOuidServiceImpl(String serverUrl, String appKey, String appSecret, String sessionKey) {
        taobaoClient = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
        //默认重试3次,重试间隔默认为100ms
//        taobaoClient = new AutoRetryTaobaoClient(serverUrl, appKey, appSecret);
        this.sessionKey = sessionKey;
    }


    @Override
    public <T extends TaobaoResponse> T execute(TaobaoRequest<T> request) throws ApiException {

//        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "34047802", "3c8a542f3a5ebab10cf309ed8d190533");
//
//        TradeSimpleGetRequest req = new TradeSimpleGetRequest();
//        req.setFields("tid,type,status,payment,orders,promotion_details");
//        req.setTid(2836874521896159621L);
//        //refresh_token: 6101c15463df5d30798b09f199de32fa444851555b8b74f420567757
//        TradeSimpleGetResponse rsp = client.execute(req, "61008159a9c54270246cf2f1a46b05b15e751bb78d55f01420567757");
//        System.out.println(rsp.getBody());


        return this.taobaoClient.execute(request, this.sessionKey);
    }
}

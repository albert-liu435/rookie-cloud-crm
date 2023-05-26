package com.rookie.bigdata.service.taobao;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;

/**
 * @Class OrderOuidService
 * @Description 根据淘宝的订单号换取阿里会员通的ouid
 * @Author rookie
 * @Date 2023/5/26 9:49
 * @Version 1.0
 */
public interface TaoBaoOrderOuidService {


    <T extends TaobaoResponse> T execute(TaobaoRequest<T> request) throws ApiException;
}

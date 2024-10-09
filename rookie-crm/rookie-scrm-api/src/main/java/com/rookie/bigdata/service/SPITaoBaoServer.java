package com.rookie.bigdata.service;

import com.rookie.bigdata.domain.taobao.TaoBaoBindQueryRequest;
import com.rookie.bigdata.domain.taobao.TaoBaoBindQueryResponse;

/**
 * @Class SPITaoBaoServer
 * @Description
 * @Author rookie
 * @Date 2024/10/9 9:38
 * @Version 1.0
 */

public interface SPITaoBaoServer {


    /**
     * 淘宝进行绑定查询操作
     *
     * @param taoBaoBindQuery
     * @return
     */
    TaoBaoBindQueryResponse bindquery(TaoBaoBindQueryRequest taoBaoBindQuery);
}

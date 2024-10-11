package com.rookie.bigdata.service;


import com.rookie.bigdata.domain.vop.VopBindQueryResponse;
import com.rookie.bigdata.domain.vop.VopMember;

import java.util.Map;

/**
 * @Class SPITaoBaoServer
 * @Description
 * @Author rookie
 * @Date 2024/10/9 9:38
 * @Version 1.0
 */

public interface SPIVopServer {


    /**
     * 进行会员和粉丝的查询
     *
     * @param params
     * @return
     */
    VopBindQueryResponse<VopMember> vopQueryBind(Map<String, Object> params) throws Exception;
}

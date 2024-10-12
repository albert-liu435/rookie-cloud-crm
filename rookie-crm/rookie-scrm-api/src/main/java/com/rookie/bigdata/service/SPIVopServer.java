package com.rookie.bigdata.service;


import com.rookie.bigdata.domain.vop.VopSPIResponse;
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
    VopSPIResponse<VopMember> vopQueryBind(Map<String, Object> params) throws Exception;

    /**
     * 进行会员粉丝的绑定操作
     *
     * @param params
     * @param jsonBody
     * @return
     */
    VopSPIResponse<VopMember> vopBind(Map<String, Object> params, String jsonBody);

    /**
     * 进行粉丝的解绑操作
     *
     * @param params
     * @param jsonBody
     * @return
     */
    VopSPIResponse<VopMember> vopUnBind(Map<String, Object> params, String jsonBody);

    /**
     * 进行会员的注册
     *
     * @param params
     * @param jsonBody
     * @return
     */
    VopSPIResponse<VopMember> vopRegister(Map<String, Object> params, String jsonBody);
}

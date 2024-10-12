package com.rookie.bigdata.service;

import java.util.Map;

/**
 * @Class VopClientService
 * @Description
 * @Author rookie
 * @Date 2024/10/10 15:57
 * @Version 1.0
 */
public interface VopClientService {



    String getAppKey();
    String getAppSecret();


    /**
     * 进行校验，即验签
     *
     * @param params
     * @param receivedSig
     * @return
     */
    boolean verifySign(Map<String, Object> params, String receivedSig);


    /**
     * 对手机号进行解析成明文手机号
     *
     * @param source
     * @return
     * @throws Exception
     */
    String decrypt(String source) throws Exception;
}

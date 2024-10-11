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

    /**
     * 进行校验，即验签
     *
     * @param params
     * @param receivedSig
     * @return
     */
    boolean verifySign(Map<String, Object> params, String receivedSig);
}

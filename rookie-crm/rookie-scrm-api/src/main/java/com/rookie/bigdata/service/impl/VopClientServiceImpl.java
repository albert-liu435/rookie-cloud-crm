package com.rookie.bigdata.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.rookie.bigdata.service.VopClientService;
import com.rookie.bigdata.util.VopAesEncryptUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Class VopClientServiceImpl
 * @Description
 * @Author rookie
 * @Date 2024/10/10 15:57
 * @Version 1.0
 */
@Slf4j
public class VopClientServiceImpl implements VopClientService {


    private String appKey;

    private String appSecret;

    private String appToken;

    private String brand;


    public VopClientServiceImpl(String appKey, String appSecret, String appToken, String brand) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.appToken = appToken;
        this.brand = brand;

    }

    @Override
    public boolean verifySign(Map<String, Object> params, String receivedSig) {
        //        https://blog.51cto.com/u_15320818/3253260
//        https://blog.csdn.net/qq_32332777/article/details/120325985
        String content = this.appSecret + MapUtil.sortJoin(params, "&", "=", true, null) + this.appSecret;
        String md5Str32Upper = SecureUtil.md5(content).toUpperCase();

        return md5Str32Upper.equals(receivedSig);
    }




    @Override
    public String decrypt(String source) throws Exception {

        return VopAesEncryptUtils.decrypt(source, this.appKey);
    }



}

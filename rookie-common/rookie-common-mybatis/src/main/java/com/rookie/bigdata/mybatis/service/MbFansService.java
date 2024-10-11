package com.rookie.bigdata.mybatis.service;

import com.rookie.bigdata.common.MbFans;

/**
 * @Class MbFansService
 * @Description
 * @Author rookie
 * @Date 2024/10/11 17:08
 * @Version 1.0
 */
public interface MbFansService {

    /**
     * 根据请求参数查询MbFans信息
     *
     * @param openId openId
     * @param id     会员唯一ID
     * @param type   粉丝类型
     * @return
     */
    MbFans getMbFansByParams(String openId, long id, String type);
}

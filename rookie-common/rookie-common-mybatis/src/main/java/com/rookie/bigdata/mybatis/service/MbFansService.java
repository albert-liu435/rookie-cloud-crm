package com.rookie.bigdata.mybatis.service;

import com.rookie.bigdata.common.MbFans;
import com.rookie.bigdata.common.MbUser;

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
     * @param userId 会员唯一ID
     * @param type   粉丝类型
     * @return
     */
    MbFans getMbFansByParams(String openId, long userId, String type);

    /**
     * 进行MbFans创建并insert
     *
     * @param mbUser 会员信息
     * @param openId 粉丝openid
     * @param type   粉丝类型
     * @return
     */
    MbFans createMbFans(MbUser mbUser, String openId, String type);

    /**
     * 对MbFans进行更新操作
     *
     * @param mbFans
     * @return
     */
    int updateMbFansUserId(MbFans mbFans);
}

package com.rookie.bigdata.mybatis.service;

import com.rookie.bigdata.common.MbLevel;
import com.rookie.bigdata.common.MbUser;

/**
 * @Class MbUserService
 * @Description
 * @Author rookie
 * @Date 2024/10/11 16:57
 * @Version 1.0
 */
public interface MbUserService {


    /**
     * 根据会员编号查询会员信息
     *
     * @param memberNo 会员编号
     * @return
     */
    MbUser getMbUserByParams(String memberNo);

    /**
     * 根据手机号和品牌查询会员信息
     *
     * @param phone     手机号
     * @param brandCode 品牌 code
     * @return
     */
    MbUser getMbUserByParams(String phone, String brandCode);

    /**
     * 根据手机号,会员编号,品牌查询会员信息
     *
     * @param phone     手机号
     * @param brandCode 品牌 code
     * @param memberNo  会员编号
     * @return
     */
    MbUser getMbUserByParams(String memberNo, String phone, String brandCode);

    /**
     * 创建会员信息
     *
     * @param phone         手机号
     * @param brandCode     品牌
     * @param regChannel    注册渠道
     * @param regSubChannel 注册子渠道
     * @param mbLevel       等级信息
     * @return
     */
    MbUser createMbUser(String phone, String brandCode, String regChannel, String regSubChannel, MbLevel mbLevel);

    /**
     * 创建会员信息
     *
     * @param phone         手机号
     * @param brandCode     品牌
     * @param regChannel    注册渠道
     * @param regSubChannel 注册子渠道
     * @param mbLevel       等级信息
     * @param point         注册赠送的积分
     * @return
     */
    MbUser createMbUser(String phone, String brandCode, String regChannel, String regSubChannel, MbLevel mbLevel, long point);
}

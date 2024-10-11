package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.MbUser;

import java.util.List;
import java.util.Map;

/**
 * @Class FansMapper
 * @Description 用于查询应用的信息
 * @Author rookie
 * @Date 2024/10/8 16:41
 * @Version 1.0
 */
public interface MbUserMapper {

    /**
     * 查询所有的用户信息
     *
     * @return
     */
    List<MbUser> getAll();

    /**
     * 根据请求参数查找会员信息
     *
     * @param map
     * @return
     */
    MbUser getMbUserByMap(Map<String, String> map);

//    /**
//     * 根据Brand Code获取Brand信息
//     *
//     * @param brandCode
//     * @return
//     */
//    Brand getBrandByCode(@Param("brandCode") String brandCode);
}

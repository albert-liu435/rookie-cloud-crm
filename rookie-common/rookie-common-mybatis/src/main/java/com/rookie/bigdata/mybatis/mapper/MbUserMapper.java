package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.MbUser;

import java.util.List;

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

//    /**
//     * 根据Brand Code获取Brand信息
//     *
//     * @param brandCode
//     * @return
//     */
//    Brand getBrandByCode(@Param("brandCode") String brandCode);
}

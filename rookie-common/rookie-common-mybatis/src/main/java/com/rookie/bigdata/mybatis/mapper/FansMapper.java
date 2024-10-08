package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.Fans;

import java.util.List;

/**
 * @Class FansMapper
 * @Description 用于查询粉丝的Mapper
 * @Author rookie
 * @Date 2024/10/8 16:41
 * @Version 1.0
 */
public interface FansMapper {

    List<Fans> getAll();
}

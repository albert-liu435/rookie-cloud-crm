package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.MbLevel;

import java.util.List;

/**
 * @Class MbLevelMapper
 * @Description
 * @Author rookie
 * @Date 2024/10/11 16:59
 * @Version 1.0
 */
public interface MbLevelMapper {

    /**
     * 查询所有的等级信息
     *
     * @return
     */
    List<MbLevel> getAll();
}

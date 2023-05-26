package com.rookie.bigdata.mapper;

import com.rookie.bigdata.entity.crm.Fans;

import java.util.Map;

/**
 * @Class FansMapper
 * @Description FansMapper
 * @Author rookie
 * @Date 2023/5/26 11:38
 * @Version 1.0
 */
public interface FansMapper {
    /**
     * 根据map参数查询粉丝的信息
     *
     * @param map
     * @return
     */
    Fans selectFansByMap(Map<String, String> map);
}

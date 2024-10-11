package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.CgApp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Class FansMapper
 * @Description 用于查询应用的信息
 * @Author rookie
 * @Date 2024/10/8 16:41
 * @Version 1.0
 */
public interface CgAppMapper {

    /**
     * 查询所有的应用信息
     *
     * @return
     */
    List<CgApp> getAll();


    CgApp getAppByType(@Param("type") String type);

    List<CgApp> getAllAppByType(String type);

}

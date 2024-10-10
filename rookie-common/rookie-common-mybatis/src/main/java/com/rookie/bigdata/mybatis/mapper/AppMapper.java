package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.App;
import com.rookie.bigdata.common.Fans;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Class FansMapper
 * @Description 用于查询应用的信息
 * @Author rookie
 * @Date 2024/10/8 16:41
 * @Version 1.0
 */
public interface AppMapper {

    /**
     * 查询所有的应用信息
     *
     * @return
     */
    List<App> getAll();


    App getAppByType(@Param("type") String type);

//    int deleteByCreateTime(@Param("sesstionDate") LocalDateTime sesstionDate);
}

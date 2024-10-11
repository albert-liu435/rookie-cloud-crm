package com.rookie.bigdata.mybatis.mapper;

import com.rookie.bigdata.common.MbBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Class FansMapper
 * @Description 用于查询应用的信息
 * @Author rookie
 * @Date 2024/10/8 16:41
 * @Version 1.0
 */
public interface MbBrandMapper {

    /**
     * 查询所有的品牌信息
     *
     * @return
     */
    List<MbBrand> getAll();

    /**
     * 根据Brand Code获取Brand信息
     *
     * @param brandCode
     * @return
     */
    MbBrand getBrandByCode(@Param("brandCode") String brandCode);
}

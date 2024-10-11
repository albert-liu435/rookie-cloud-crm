package com.rookie.bigdata.mybatis.service;

import com.rookie.bigdata.common.MbBrand;

/**
 * @Class BrandService
 * @Description
 * @Author rookie
 * @Date 2024/10/11 9:57
 * @Version 1.0
 */
public interface MbBrandService {


    /**
     * 根据brand code获取brand信息
     *
     * @param brandCode
     * @return
     */
    MbBrand getBrandByCode(String brandCode);
}

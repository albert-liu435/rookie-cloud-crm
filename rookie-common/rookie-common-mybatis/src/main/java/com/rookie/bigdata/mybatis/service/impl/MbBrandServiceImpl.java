package com.rookie.bigdata.mybatis.service.impl;

import com.rookie.bigdata.common.MbBrand;
import com.rookie.bigdata.mybatis.mapper.MbBrandMapper;
import com.rookie.bigdata.mybatis.service.MbBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class BrandServiceImpl
 * @Description
 * @Author rookie
 * @Date 2024/10/11 9:57
 * @Version 1.0
 */
@Service
@Slf4j
public class MbBrandServiceImpl implements MbBrandService {

    @Autowired
    private MbBrandMapper brandMapper;


    @Override
    public MbBrand getBrandByCode(String brandCode) {
        return brandMapper.getBrandByCode(brandCode);
    }
}

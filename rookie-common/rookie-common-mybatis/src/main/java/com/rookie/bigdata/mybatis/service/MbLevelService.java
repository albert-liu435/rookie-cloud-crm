package com.rookie.bigdata.mybatis.service;

import com.rookie.bigdata.common.MbLevel;

/**
 * @Class MbLevelService
 * @Description
 * @Author rookie
 * @Date 2024/10/11 17:02
 * @Version 1.0
 */
public interface MbLevelService {

    /**
     * 根据品牌和等级编码选择等级信息
     *
     * @param brandCode
     * @param levelNo
     * @return
     */
    MbLevel getLevelByBrand(String brandCode, String levelNo);
}

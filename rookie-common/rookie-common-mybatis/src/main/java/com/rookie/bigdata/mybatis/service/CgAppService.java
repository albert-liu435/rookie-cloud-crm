package com.rookie.bigdata.mybatis.service;

import com.rookie.bigdata.common.CgApp;

import java.util.List;

/**
 * @Class AppService
 * @Description
 * @Author rookie
 * @Date 2024/10/11 9:16
 * @Version 1.0
 */
public interface CgAppService {


    /**
     * 根据type 类型获取所有的App
     *
     * @param type 1:唯品会应用
     * @return
     */
    List<CgApp> getAllAppByType(String type);

}

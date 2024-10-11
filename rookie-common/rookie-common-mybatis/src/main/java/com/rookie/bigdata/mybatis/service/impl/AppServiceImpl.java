package com.rookie.bigdata.mybatis.service.impl;

import com.rookie.bigdata.common.App;
import com.rookie.bigdata.mybatis.mapper.AppMapper;
import com.rookie.bigdata.mybatis.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Class AppServiceImpl
 * @Description
 * @Author rookie
 * @Date 2024/10/11 9:16
 * @Version 1.0
 */
@Service
@Slf4j
public class AppServiceImpl implements AppService {

    @Autowired
    private AppMapper appMapper;

    @Override
    public List<App> getAllAppByType(String type) {
        return appMapper.getAllAppByType(type);
    }
}

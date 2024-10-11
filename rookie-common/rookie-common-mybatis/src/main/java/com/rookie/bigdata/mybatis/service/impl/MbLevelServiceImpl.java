package com.rookie.bigdata.mybatis.service.impl;

import com.rookie.bigdata.mybatis.mapper.MbLevelMapper;
import com.rookie.bigdata.mybatis.service.MbLevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class MbLevelServiceImpl
 * @Description
 * @Author rookie
 * @Date 2024/10/11 17:03
 * @Version 1.0
 */
@Service
@Slf4j
public class MbLevelServiceImpl implements MbLevelService {

    @Autowired
    private MbLevelMapper mbLevelMapper;


}

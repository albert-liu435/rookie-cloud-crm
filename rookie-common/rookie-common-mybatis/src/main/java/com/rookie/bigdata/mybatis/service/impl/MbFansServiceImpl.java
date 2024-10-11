package com.rookie.bigdata.mybatis.service.impl;

import com.rookie.bigdata.mybatis.mapper.MbFansMapper;
import com.rookie.bigdata.mybatis.service.MbFansService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class MbFansServiceImpl
 * @Description
 * @Author rookie
 * @Date 2024/10/11 17:08
 * @Version 1.0
 */
@Service
@Slf4j
public class MbFansServiceImpl implements MbFansService {

    @Autowired
    private MbFansMapper mbFansMapper;
}

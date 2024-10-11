package com.rookie.bigdata.mybatis.service.impl;

import com.rookie.bigdata.common.MbUser;
import com.rookie.bigdata.mybatis.mapper.MbUserMapper;
import com.rookie.bigdata.mybatis.service.MbUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class MbUserServiceImpl
 * @Description
 * @Author rookie
 * @Date 2024/10/11 16:57
 * @Version 1.0
 */
@Service
@Slf4j
public class MbUserServiceImpl implements MbUserService {

    @Autowired
    private MbUserMapper mbUserMapper;


    @Override
    public MbUser getMbUserByParams(String phone, String brandCode) {
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("brandCode", brandCode);
        return mbUserMapper.getMbUserByMap(map);
    }
}

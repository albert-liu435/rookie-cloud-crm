package com.rookie.bigdata.mybatis.service.impl;

import com.rookie.bigdata.common.MbLevel;
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
    public MbUser getMbUserByParams(String memberNo) {
        return getMbUserByParams(memberNo, null, null);
    }

    @Override
    public MbUser getMbUserByParams(String phone, String brandCode) {
        return getMbUserByParams(phone, brandCode, null);
    }

    @Override
    public MbUser getMbUserByParams(String memberNo, String phone, String brandCode) {
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("brandCode", brandCode);
        map.put("memberNo", memberNo);
        return mbUserMapper.getMbUserByMap(map);
    }

    @Override
    public MbUser createMbUser(String phone, String brandCode, String regChannel, String regSubChannel, MbLevel mbLevel) {
        return createMbUser(phone, brandCode, regChannel, regSubChannel, mbLevel, 100);
    }

    @Override
    public MbUser createMbUser(String phone, String brandCode, String regChannel, String regSubChannel, MbLevel mbLevel, long point) {
        MbUser mbUser = new MbUser();
        mbUser.setPhone(phone);
        mbUser.setBrandCode(brandCode);
        mbUser.setRegChannel(regChannel);
        mbUser.setRegSubChannel(regSubChannel);
        mbUser.setLevelName(mbLevel.getLevelName());
        mbUser.setLevelNo(mbLevel.getLevelNo());
        //TODO 注册日期,后续进行处理

        int insertCount = mbUserMapper.insertMbUser(mbUser);
        if (insertCount > 0) {
            return mbUser;
        }


        return mbUser;
    }
}

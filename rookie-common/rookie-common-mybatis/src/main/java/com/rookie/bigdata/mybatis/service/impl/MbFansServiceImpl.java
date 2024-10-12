package com.rookie.bigdata.mybatis.service.impl;

import com.rookie.bigdata.common.MbFans;
import com.rookie.bigdata.common.MbUser;
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

    @Override
    public MbFans getMbFansByParams(String openId, long userId, String type) {
        // 进行粉丝信息的查询
        MbFans mbFans = new MbFans();
        mbFans.setOpenId(openId);
        mbFans.setUserId(userId);
        mbFans.setType(type);

        return mbFansMapper.getOneMbFansByMbFans(mbFans);
    }

    @Override
    public MbFans createMbFans(MbUser mbUser, String openId,String type) {
        MbFans mbFans=new MbFans();
        mbFans.setOpenId(openId);
        mbFans.setType(type);
        mbFans.setUserId(mbUser.getId());

        int insertCount=mbFansMapper.insertMbFans(mbFans);
        if(insertCount>0){
            return mbFans;
        }


        return null;
    }

    @Override
    public int updateMbFansUserId(MbFans mbFans) {
        return mbFansMapper.updateMbFansUserId(mbFans);
    }
}

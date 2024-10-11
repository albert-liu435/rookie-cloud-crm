package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.common.MbBrand;
import com.rookie.bigdata.common.MbFans;
import com.rookie.bigdata.common.MbUser;
import com.rookie.bigdata.config.VopComServiceConfig;
import com.rookie.bigdata.domain.vop.VopBindQueryResponse;
import com.rookie.bigdata.domain.vop.VopMember;
import com.rookie.bigdata.enums.SPIVopEnum;
import com.rookie.bigdata.mybatis.service.MbBrandService;
import com.rookie.bigdata.mybatis.service.MbFansService;
import com.rookie.bigdata.mybatis.service.MbUserService;
import com.rookie.bigdata.service.SPIVopServer;
import com.rookie.bigdata.service.VopClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class SPIVopServerImpl
 * @Description
 * @Author rookie
 * @Date 2024/10/11 8:59
 * @Version 1.0
 */


@Service
@Slf4j
public class SPIVopServerImpl implements SPIVopServer {


    @Autowired
    private MbBrandService brandService;

    @Autowired
    private MbUserService mbUserService;

    @Autowired
    private MbFansService mbFansService;


    @Override
    public VopBindQueryResponse<VopMember> vopQueryBind(Map<String, Object> params) throws Exception {

        VopBindQueryResponse<VopMember> vopBindQueryResponse = new VopBindQueryResponse<VopMember>();
        //系统异常
        vopBindQueryResponse.setCode(SPIVopEnum.E06.getCode());
        vopBindQueryResponse.setMessage(SPIVopEnum.E06.getMsg());
        VopMember vopMember = new VopMember();
        vopMember.setBindAble(false);
        vopBindQueryResponse.setContent(vopMember);

        //获取品牌
        String brandCode = (String) params.get("brand_identify");
        //获取service进行认证及其他信息
        VopClientService vopClientService = VopComServiceConfig.getVopClientService(brandCode);

        String receivedSig = (String) params.remove("sign");
        //进行验签,如果验签通过后则进行品牌查询
        boolean flag = vopClientService.verifySign(params, receivedSig);

        // 查询品牌信息
        MbBrand brand = brandService.getBrandByCode(brandCode);

        if (flag) {
            //校验通过
            //需要将手机号进行解密
            String paramPhone = (String) params.get("mix_mobile");
            //明文手机号
            String phone = vopClientService.decrypt(paramPhone);
            // 根据手机号和品牌查询会员信息是否存在
            MbUser mbUser = mbUserService.getMbUserByParams(phone, brand.getBrandCode());
            //会员信息不存在，说明可以进行注册
            if (null == mbUser) {
                vopBindQueryResponse.setCode(SPIVopEnum.E03.getCode());
                vopBindQueryResponse.setMessage(SPIVopEnum.E03.getMsg());
                vopMember.setBindAble(false);
                return vopBindQueryResponse;
            }
            //会员信息存在，查询粉丝信息是否存在
            String openId = (String) params.get("open_id");
            //根据openid查询粉丝信息和会员信息
            Map<String, Object> fansLeadMap = new HashMap<>();
            fansLeadMap.put("accountGuid", mbUser.getId());
            fansLeadMap.put("openId", openId);
            fansLeadMap.put("type", "14");
            MbFans mbFans = mbFansService.getMbFansByParams(openId, mbUser.getId(), "1");

            //粉丝不存在，可以绑定
            if (null == mbFans) {
                vopBindQueryResponse.setCode(SPIVopEnum.E04.getCode());
                vopBindQueryResponse.setMessage(SPIVopEnum.E04.getMsg());
                //TODO 这里需要会员编号
                vopMember.setBindAble(true);

                vopMember.setMemberNo(mbUser.getMemberNo());
                return vopBindQueryResponse;
            }
            //如果粉丝和会员都存在
            vopBindQueryResponse.setCode(SPIVopEnum.E05.getCode());
            vopBindQueryResponse.setMessage(SPIVopEnum.E05.getMsg());
            vopMember.setBindAble(false);
            return vopBindQueryResponse;
        }
        return vopBindQueryResponse;

    }
}

package com.rookie.bigdata.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rookie.bigdata.common.MbBrand;
import com.rookie.bigdata.common.MbFans;
import com.rookie.bigdata.common.MbUser;
import com.rookie.bigdata.config.VopComServiceConfig;
import com.rookie.bigdata.domain.vop.VopMemRequest;
import com.rookie.bigdata.domain.vop.VopSPIResponse;
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


    //Json转换工具类, 不返回设置值为null的property
    protected final Gson ngson = new GsonBuilder()//建造者模式设置不同的配置
            .disableHtmlEscaping()//防止对网址乱码 忽略对特殊字符的转换
            .create();


    @Autowired
    private MbBrandService brandService;

    @Autowired
    private MbUserService mbUserService;

    @Autowired
    private MbFansService mbFansService;


    @Override
    public VopSPIResponse<VopMember> vopQueryBind(Map<String, Object> params) throws Exception {

        VopSPIResponse<VopMember> vopSPIResponse = new VopSPIResponse<VopMember>();
        //系统异常
        vopSPIResponse.setCode(SPIVopEnum.E06.getCode());
        vopSPIResponse.setMessage(SPIVopEnum.E06.getMsg());
        VopMember vopMember = new VopMember();
        vopMember.setBindAble(false);
        vopSPIResponse.setContent(vopMember);

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
                vopSPIResponse.setCode(SPIVopEnum.E03.getCode());
                vopSPIResponse.setMessage(SPIVopEnum.E03.getMsg());
                vopMember.setBindAble(false);
                return vopSPIResponse;
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
                vopSPIResponse.setCode(SPIVopEnum.E04.getCode());
                vopSPIResponse.setMessage(SPIVopEnum.E04.getMsg());
                // 这里需要会员编号
                vopMember.setBindAble(true);
                vopMember.setMemberNo(mbUser.getMemberNo());
                return vopSPIResponse;
            }
            //如果粉丝和会员都存在
            vopSPIResponse.setCode(SPIVopEnum.E05.getCode());
            vopSPIResponse.setMessage(SPIVopEnum.E05.getMsg());
            vopMember.setBindAble(false);
            return vopSPIResponse;
        }
        return vopSPIResponse;

    }

    @Override
    public VopSPIResponse<VopMember> vopBind(Map<String, Object> params, String jsonBody) {

        VopSPIResponse<VopMember> vopSPIResponse = new VopSPIResponse<VopMember>();
        //系统异常
        vopSPIResponse.setCode(SPIVopEnum.E06.getCode());
        vopSPIResponse.setMessage(SPIVopEnum.E06.getMsg());
        VopMember vopMember = new VopMember();
        vopSPIResponse.setContent(vopMember);

        //获取品牌
        String brandCode = (String) params.get("brand_identify");
        //获取service进行认证及其他信息
        VopClientService vopClientService = VopComServiceConfig.getVopClientService(brandCode);
        String receivedSig = (String) params.remove("sign");
        params.put("body", jsonBody);
        //进行验签,如果验签通过后则进行品牌查询
        boolean flag = vopClientService.verifySign(params, receivedSig);

        // 查询品牌信息
        MbBrand brand = brandService.getBrandByCode(brandCode);
        // 判断校验是否通过
        if (flag) {
            VopMemRequest vopMemRequest = ngson.fromJson(jsonBody, VopMemRequest.class);
            //会员编号
            String memberNo = vopMemRequest.getBrandCardId();
            // 根据会员编号查询会员信息
            MbUser mbUser = mbUserService.getMbUserByParams(memberNo, null, brand.getBrandCode());
            //会员不存在
            if (null == mbUser) {
                vopSPIResponse.setCode(SPIVopEnum.E07.getCode());
                vopSPIResponse.setMessage(SPIVopEnum.E07.getMsg());
                return vopSPIResponse;
            }
            long point = mbUser.getPoint();
            String levelNo = mbUser.getLevelNo();

            //会员存在，根据信息查询粉丝信息
            String openId = vopMemRequest.getOpenId();

            //跟进openid查询粉丝信息,理论上openid是和抖音上面的店铺相对应的，所以这里暂时只用openid查询信息
            MbFans mbFan = mbFansService.getMbFansByParams(openId, mbUser.getId(), "1");
            //粉丝不存在，可以绑定,会员存在返回错误信息
            if (null != mbFan) {
                vopSPIResponse.setCode(SPIVopEnum.E08.getCode());
                vopSPIResponse.setMessage(SPIVopEnum.E08.getMsg());
                vopMember.setLevel(levelNo);
                vopMember.setPoint(point);
                return vopSPIResponse;
            }

            //TODO 构建粉丝并进行insert操作

            //构建粉丝信息，并进行insert操作
            MbFans fansLead = mbFansService.createMbFans(mbUser, openId, "1");

            //如果粉丝和会员都存在
            vopSPIResponse.setCode(SPIVopEnum.SUC.getCode());
            vopSPIResponse.setMessage(SPIVopEnum.SUC.getMsg());
            vopMember.setLevel(levelNo);
            vopMember.setPoint(point);
            return vopSPIResponse;
        }
        // 系统异常
        return vopSPIResponse;
    }

    @Override
    public VopSPIResponse<VopMember> vopUnBind(Map<String, Object> params, String jsonBody) {

        VopSPIResponse<VopMember> vopSPIResponse = new VopSPIResponse<VopMember>();
        //系统异常
        vopSPIResponse.setCode(SPIVopEnum.E06.getCode());
        vopSPIResponse.setMessage(SPIVopEnum.E06.getMsg());

        //获取品牌
        String brandCode = (String) params.get("brand_identify");
        //获取service进行认证及其他信息
        VopClientService vopClientService = VopComServiceConfig.getVopClientService(brandCode);
        String receivedSig = (String) params.remove("sign");
        params.put("body", jsonBody);
        //进行验签,如果验签通过后则进行品牌查询
        boolean flag = vopClientService.verifySign(params, receivedSig);
        // 查询品牌信息
        MbBrand brand = brandService.getBrandByCode(brandCode);

        // 判断校验是否通过
        if (flag) {
            VopMemRequest vopMemRequest = ngson.fromJson(jsonBody, VopMemRequest.class);
            String openId = vopMemRequest.getOpenId();
            //查询出会员信息
            MbUser mbUser = mbUserService.getMbUserByParams(vopMemRequest.getBrandCardId());
            // 需要判断会员是否存在
            if (null != mbUser) {
                vopSPIResponse.setCode(SPIVopEnum.E11.getCode());
                vopSPIResponse.setMessage(SPIVopEnum.E11.getMsg());
                return vopSPIResponse;
            }

            MbFans mbFans = mbFansService.getMbFansByParams(openId, mbUser.getId(), "1");

            if (null == mbFans) {
                log.error("VOP无绑定关系:{}", jsonBody);
                vopSPIResponse.setCode(SPIVopEnum.E09.getCode());
                vopSPIResponse.setMessage(SPIVopEnum.E09.getMsg());
                return vopSPIResponse;
            }

            //进行更新操作
            int updateCount = mbFansService.updateMbFansUserId(mbFans);

            if (updateCount > 0) {
                vopSPIResponse.setCode(SPIVopEnum.SUC.getCode());
                vopSPIResponse.setMessage(SPIVopEnum.SUC.getMsg());
                return vopSPIResponse;
            }

        }
        // 系统异常
        return vopSPIResponse;
    }

    @Override
    public VopSPIResponse<VopMember> vopRegister(Map<String, Object> params, String jsonBody) {
        return null;
    }
}

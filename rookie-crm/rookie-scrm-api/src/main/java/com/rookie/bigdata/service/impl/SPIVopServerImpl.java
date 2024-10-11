package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.config.VopComServiceConfig;
import com.rookie.bigdata.domain.vop.VopBindQueryResponse;
import com.rookie.bigdata.domain.vop.VopMember;
import com.rookie.bigdata.enums.SPIVopEnum;
import com.rookie.bigdata.service.SPIVopServer;
import com.rookie.bigdata.service.VopClientService;
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
public class SPIVopServerImpl implements SPIVopServer {
    @Override
    public VopBindQueryResponse<VopMember> vopQueryBind(Map<String, Object> params) {

        VopBindQueryResponse<VopMember> vopBindQueryResponse = new VopBindQueryResponse<VopMember>();
        //系统异常
        vopBindQueryResponse.setCode(SPIVopEnum.E06.getCode());
        vopBindQueryResponse.setMessage(SPIVopEnum.E06.getMsg());
        VopMember vopMember = new VopMember();
        vopMember.setBindAble(false);
//        vopMember.setMemberNo("1234abc");
        vopBindQueryResponse.setContent(vopMember);

        //获取品牌
        String brand = (String) params.get("brand_identify");
        //获取service进行认证及其他信息
        VopClientService vopClientService = VopComServiceConfig.getVopClientService(brand);

        String receivedSig = (String) params.remove("sign");
        //进行验签,如果验签通过后则进行品牌查询
        boolean flag = vopClientService.verifySign(params, receivedSig);

        //TODO 查询品牌信息


        return null;
//        QueryBindOut queryBindOut = new QueryBindOut();
//        queryBindOut.setCode(VopMemEnum.MEM_E06.getCode());
//        queryBindOut.setMessage(VopMemEnum.MEM_E06.getMsg());
//        QueryBindOut.Content content = new QueryBindOut.Content();
//        content.setBind_able(false);
//        queryBindOut.setContent(content);
//
//        //获取sign,然后根据sign校验params,校验通过后执行其他操作，如查询等操作
//        String brandIdentify = (String) params.get("brand_identify");
//        VopTokenService vopTokenService = VopComServiceConfig.getVopTokenService(brandIdentify);
//        // 提取sig参数
//        String receivedSig = (String) params.remove("sign");
//        boolean flag = vopTokenService.verifySign(params, receivedSig);
//        String brandCode = vopTokenService.getBrandCode();
//        // 判断校验是否通过
//        if (flag) {
//            //渠道和子渠道分别为 VIP VipMember
//            //根据品牌查询品牌信息
//            Brand brand = brandService.getBrandByBrandCodeOrSellerName(brandCode);
//            //需要将手机号进行解密
//            String paramPhone = (String) params.get("mix_mobile");
//            //明文手机号
//            String phone = vopTokenService.decrypt(paramPhone);
//            //查询会员信息
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            paramMap.put("memberSystem", brand.getMemberSystemGuid());
//            paramMap.put("phone", phone);
//            //查询出会员信息
//            AccountView accountView = accountService.selectAccountInfo(paramMap);
//
//            //会员不存在的话 就返回可以注册
//            if (null == accountView) {
//                queryBindOut.setCode(VopMemEnum.MEM_E03.getCode());
//                queryBindOut.setMessage(VopMemEnum.MEM_E03.getMsg());
//                content.setBind_able(true);
//                return queryBindOut;
//            }
//
//            //会员存在，根据信息查询粉丝信息
//            String open_id = (String) params.get("open_id");
//            //根据openid查询粉丝信息和会员信息
//            Map<String, String> fansLeadMap = new HashMap<>();
//            fansLeadMap.put("accountGuid", accountView.getAccountGuidId());
//            fansLeadMap.put("openId", open_id);
//            fansLeadMap.put("type", "14");
//            //跟进openid查询粉丝信息,理论上openid是和抖音上面的店铺相对应的，所以这里暂时只用openid查询信息
//            FansLeads fansLeads = fansLeadsService.getOneFansLeads(fansLeadMap);
//            //粉丝不存在，可以绑定
//            if (null == fansLeads) {
//                queryBindOut.setCode(VopMemEnum.MEM_E04.getCode());
//                queryBindOut.setMessage(VopMemEnum.MEM_E04.getMsg());
//                content.setBind_able(true);
//                content.setBrand_member_card_id(accountView.getMemberNo());
//                return queryBindOut;
//            }
//
//            //如果粉丝和会员都存在
//            queryBindOut.setCode(VopMemEnum.MEM_E05.getCode());
//            queryBindOut.setMessage(VopMemEnum.MEM_E05.getMsg());
//            content.setBind_able(false);
//            return queryBindOut;
//        }
//
//        // 系统异常
//        return queryBindOut;
    }
}

package com.rookie.bigdata.entity.taobao;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @Class TaoBaoBindQueryIn
 * @Description
 * @Author rookie
 * @Date 2023/5/26 11:22
 * @Version 1.0
 */
public class TaoBaoBindQueryIn implements Serializable {


    @SerializedName("seller_name")
    private String sellerName; //卖家昵称

    @SerializedName("mix_mobile")
    private String mixMobile; //默认密文手机号码

    private String ouid;//淘宝买家在当前店铺的唯一标识

    private String omid; //淘宝买家在当前品牌/企业的唯一标识，需做品牌认领

    private String extend; //extend{"alipay_user_id":"2088702372175543","flightMode":"1","flightJoinTime":"2018-05-18 01:16:23" }


    //明文手机号
    private String mobile;
    //买家昵称
    private String nick;
//    @SerializedName("open_id")
//    private String openId;
//    @SerializedName("union_id")
//    private String unionId;


    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getMixMobile() {
        return mixMobile;
    }

    public void setMixMobile(String mixMobile) {
        this.mixMobile = mixMobile;
    }

    public String getOuid() {
        return ouid;
    }

    public void setOuid(String ouid) {
        this.ouid = ouid;
    }

    public String getOmid() {
        return omid;
    }

    public void setOmid(String omid) {
        this.omid = omid;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}

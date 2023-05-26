package com.rookie.bigdata.entity.taobao;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @Class TaoBaoMember
 * @Description
 * @Author rookie
 * @Date 2023/5/26 15:16
 * @Version 1.0
 */
public class TaoBaoMember implements Serializable {

    private int point; //当前积分

    private int level;//会员等级

    private String ouid;//淘宝买家在当前店铺的唯一标识

    @SerializedName("mix_mobile")
    private String mixMobile; //会员密文手机号码


    //查询请求需要返回明文手机号，不需要这个上面的密文手机号
    //其中 mobile和nick是老接口注册的信息
    private String mobile;//明文手机号码
    private String nick; //昵称

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getOuid() {
        return ouid;
    }

    public void setOuid(String ouid) {
        this.ouid = ouid;
    }

    public String getMixMobile() {
        return mixMobile;
    }

    public void setMixMobile(String mixMobile) {
        this.mixMobile = mixMobile;
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

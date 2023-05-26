package com.rookie.bigdata.entity.taobao;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @Class TaoBaoBindQueryOut
 * @Description
 * @Author rookie
 * @Date 2023/5/26 11:25
 * @Version 1.0
 */
public class TaoBaoBindQueryOut implements Serializable {

    @SerializedName("bind_code")
    private String bindCode; //必填 以下为不能绑定的代码，如果可绑定返回SUC(需返回明文手机号)。 E01:会员不存在 E02:会员已被绑定 E04:会员不存在，可注册 E05:系统繁忙或异常，可重试 其他原因可传F01，F02等， 系统统一识别为会员不存在


    private boolean bindable; //是否能绑定。如果返回true，则需要品牌方将明文的nick,mobile返回。


    private TaoBaoMember member;

    public String getBindCode() {
        return bindCode;
    }

    public void setBindCode(String bindCode) {
        this.bindCode = bindCode;
    }

    public boolean isBindable() {
        return bindable;
    }

    public void setBindable(boolean bindable) {
        this.bindable = bindable;
    }

    public TaoBaoMember getMember() {
        return member;
    }

    public void setMember(TaoBaoMember member) {
        this.member = member;
    }
}

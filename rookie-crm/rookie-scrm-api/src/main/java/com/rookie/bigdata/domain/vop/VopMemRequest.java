package com.rookie.bigdata.domain.vop;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Class VopMemRequest
 * @Description
 * @Author rookie
 * @Date 2024/10/12 10:11
 * @Version 1.0
 */
@Data
public class VopMemRequest implements Serializable {


    //会员的openid
    @SerializedName("open_id")
    private String openId;

    //会员编号
    @SerializedName("brand_member_card_id")
    private String brandCardId;
    //会员加密手机号
    @SerializedName("mix_mobile")
    private String mixMobile;
}

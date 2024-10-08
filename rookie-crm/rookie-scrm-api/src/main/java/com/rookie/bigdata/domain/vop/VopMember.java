package com.rookie.bigdata.domain.vop;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Class VopMember
 * @Description
 * @Author rookie
 * @Date 2024/10/10 17:37
 * @Version 1.0
 */
@Data
public class VopMember implements Serializable {

    //    @SerializedName(value = "bind_able", alternate = {"bind_able"})
    @SerializedName(value = "bind_able")
//    @JsonAlias("bind_able")
    private boolean bindAble;

    @SerializedName("brand_member_card_id")
    private String memberNo;
}

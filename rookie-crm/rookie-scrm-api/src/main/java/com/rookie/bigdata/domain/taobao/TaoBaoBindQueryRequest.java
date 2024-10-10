package com.rookie.bigdata.domain.taobao;

//import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Class TaoBaoBindQueryRequest
 * @Description
 * @Author rookie
 * @Date 2024/10/9 13:42
 * @Version 1.0
 */
@Data
public class TaoBaoBindQueryRequest implements Serializable {


    //{\"extend\":\"{\\\"flightJoinTime\\\":\\\"2024-10-09 01:07:02\\\",\\\"flightMode\\\":\\\"1\\\",\\\"level\\\":1}\",\"seller_name\":\"nationalgeographic户外店\",\"open_id\":\"AAGUAdL9AOFemXQEHNnOhyyA\",\"ouid\":\"AAG2Aa1nAAAYIPoAAVyriDOu\",
    // \"mix_mobile\":\"bb00b08174cd00b55ef948f04cd808e7\"}"


//    @SerializedName("seller_name")
    private String sellerName; //卖家昵称

//    @SerializedName("open_id")
    private String openId;
//    @SerializedName("union_id")
    private String unionId;

//    @SerializedName("mix_mobile")
    private String mixMobile; //默认密文手机号码

    private String ouid;//淘宝买家在当前店铺的唯一标识

    private String omid; //淘宝买家在当前品牌/企业的唯一标识，需做品牌认领

    private String extend; //extend{"alipay_user_id":"2088702372175543","flightMode":"1","flightJoinTime":"2018-05-18 01:16:23" }


}

package com.rookie.bigdata.domain.taobao;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Class TaoBaoBindQueryResponse
 * @Description
 * @Author rookie
 * @Date 2024/10/9 13:52
 * @Version 1.0
 */
@Data
public class TaoBaoBindQueryResponse implements Serializable {


//    是否可以绑定代码，见错误码定义，SUC:可绑定,bindable值为true；E01:会员不存在；E02:会员已被绑定；E04:会员不存在，可注册；E05:系统繁忙或异常，可重试；其他原因可传F01，F02等，系统统一识别为会员不存在

    @SerializedName("bind_code")
    private String bindCode; //必填 以下为不能绑定的代码，如果可绑定返回SUC(需返回明文手机号)。 E01:会员不存在 E02:会员已被绑定 E04:会员不存在，可注册 E05:系统繁忙或异常，可重试 其他原因可传F01，F02等， 系统统一识别为会员不存在


    private boolean bindable; //是否能绑定。如果返回true，则需要品牌方将明文的nick,mobile返回。


}

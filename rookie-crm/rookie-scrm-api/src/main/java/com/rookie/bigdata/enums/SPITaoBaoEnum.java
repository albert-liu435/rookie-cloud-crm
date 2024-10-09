package com.rookie.bigdata.enums;

/**
 * @Class SPITaoBaoEnum
 * @Description
 * @Author rookie
 * @Date 2024/10/9 10:12
 * @Version 1.0
 */
public enum SPITaoBaoEnum {


    //必填 以下为不能绑定的代码，如果可绑定返回SUC(需返回明文手机号)。 E01:会员不存在 E02:会员已被绑定 E04:会员不存在，可注册 E05:系统繁忙或异常，可重试 其他原因可传F01，F02等， 系统统一识别为会员不存在
    BIND_QUERY_E01("E01", "会员不存在"),
    BIND_QUERY_E02("E02", "会员已被绑定"),
    BIND_QUERY_E04("E04", "会员不存在，可注册"),
    BIND_QUERY_E05("E05", "系统繁忙或异常，可重试"),
    BIND_QUERY_F01("F01", "其他原因");


    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    SPITaoBaoEnum(String code, String msg) {

        this.code = code;
        this.msg = msg;
    }

}

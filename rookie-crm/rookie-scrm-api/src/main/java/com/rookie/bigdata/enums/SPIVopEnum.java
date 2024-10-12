package com.rookie.bigdata.enums;

/**
 * @Class SPIVopEnum
 * @Description
 * @Author rookie
 * @Date 2024/10/10 15:53
 * @Version 1.0
 */
public enum SPIVopEnum {


    SUC("SUC", "处理成功"),
    E01("E01", "参数错误"),
    E02("E02", "会员不存在,不可注册"),
    E03("E03", "会员不存在,可注册"),
    E04("E04", "会员已注册,可绑定"),
    E05("E05", "会员已被注册"),//open_id 和mix_mobile 同时查到同一个会员
    E051("E51", "会员手机号已被绑定"),//open_id 未查到会员，mix_mobile 查到会员了
    E52("E52", "会员平台表示已被绑定"),//mix_mobile未查到会员,open_id查到会员了
    E53("E53", "会员手机号或平台标识已被绑定"),//手机号和 open_id 均已存在(各对应一个会员，及 open_id 对 应 会 员 A ，mix_mobile 对应会员 B)
    E06("E06", "系统异常"),
    E07("E07", "绑定失败,品牌会员卡不存在,不可与平台绑定"),
    E08("E08", "绑定失败,open_id和brand_member_card_id已关联并绑定"),
    E09("E09", "绑定失败,open_id或brand_member_card_id已被占用"),

    E_09("E09", "解绑失败,该平台用户无绑定关系"),
    E10("E10", "平台用户和会员卡卡号不匹配"),
    E_10("E10", "注册失败-该用户不允许注册"),

    E11("E11", "会员卡卡号不存在"),
    E_11("E11", "注册失败-该用户已注册并绑定"),
    E12("E12", "会员不存在"),

    E99("E99","其他未知原因");


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

    SPIVopEnum(String code, String msg) {

        this.code = code;
        this.msg = msg;
    }


    }

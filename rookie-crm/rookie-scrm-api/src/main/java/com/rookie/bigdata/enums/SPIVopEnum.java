package com.rookie.bigdata.enums;

/**
 * @Class SPIVopEnum
 * @Description
 * @Author rookie
 * @Date 2024/10/10 15:53
 * @Version 1.0
 */
public enum SPIVopEnum {


    E01("E01", "参数错误"),
    E02("E02", "会员不存在,不可注册"),
    E03("E03", "会员不存在,可注册"),
    E04("E04", "会员已注册,可绑定"),
    E05("E05", "会员已被注册"),//open_id 和mix_mobile 同时查到同一个会员
    E051("E51", "会员手机号已被绑定"),//open_id 未查到会员，mix_mobile 查到会员了
    E52("E52", "会员平台表示已被绑定"),//mix_mobile未查到会员,open_id查到会员了
    E53("E53", "会员手机号或平台标识已被绑定"),//手机号和 open_id 均已存在(各对应一个会员，及 open_id 对 应 会 员 A ，mix_mobile 对应会员 B)
    E06("E06", "系统异常"),
    E99("E99", "其他未知原因");


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

package com.rookie.bigdata.common;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Class MbUser
 * @Description
 * @Author rookie
 * @Date 2024/10/11 16:38
 * @Version 1.0
 */
@Data
public class MbUser implements Serializable {
    //唯一ID
    private long id;
    //用户手机号
    private String phone;
    //等级编号
    private String levelNo;
    //等级名称
    private String levelName;
    //品牌code
    private String brandCode;
    //注册渠道
    private String regChannel;
    //注册子渠道
    private String regSubChannel;
    //注册日期
    private String regTime;
    //生日
    private String birthday;
    //邮箱
    private String email;
    //性别
    private String sex;
    //积分
    private int point;
    //创建时间
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;

}

package com.rookie.bigdata.common;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Class App
 * @Description
 * @Author rookie
 * @Date 2024/10/10 11:34
 * @Version 1.0
 */
@Data
public class App implements Serializable {

    //唯一ID
    private long id;
    //应用appKey
    private String appKey;
    //应用secret
    private String appSecret;
    //应用token
    private String appToken;
    //应用refreshtoken
    private String appRefreshtoken;
    //品牌
    private String brand;
    //token过期时间
    private LocalDateTime token_expires_time;
    //refreshtoken过期时间
    private LocalDateTime refreshtoken_expires_time;

    //1:唯品会应用
    private String type;


    //创建时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDateTime updateTime;

}

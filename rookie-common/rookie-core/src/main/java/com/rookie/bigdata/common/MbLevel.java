package com.rookie.bigdata.common;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Class MbLevel
 * @Description
 * @Author rookie
 * @Date 2024/10/11 17:00
 * @Version 1.0
 */
@Data
public class MbLevel implements Serializable {
    //唯一ID
    private long id;
    //等级编号
    private String levelNo;
    //等级名称
    private String levelName;
    //品牌code
    private String brandCode;
    //创建时间
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;
}

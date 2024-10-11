package com.rookie.bigdata.common;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Class Brand
 * @Description 品牌信息
 * @Author rookie
 * @Date 2024/10/11 9:55
 * @Version 1.0
 */
@Data
public class MbBrand implements Serializable {

    //唯一ID
    private long id;
    //品牌编码
    private String brandCode;

    //创建时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDateTime updateTime;
}

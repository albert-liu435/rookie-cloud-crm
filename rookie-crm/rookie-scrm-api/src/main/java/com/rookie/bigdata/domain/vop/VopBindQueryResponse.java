package com.rookie.bigdata.domain.vop;

import lombok.Data;

import java.io.Serializable;

/**
 * @Class VopBindQueryResponse
 * @Description https://juejin.cn/post/7151721289848193032
 * @Author rookie
 * @Date 2024/10/10 17:36
 * @Version 1.0
 */
@Data
public class VopBindQueryResponse<T> implements Serializable {

    private String code;

    private String message;

    private T content;


}

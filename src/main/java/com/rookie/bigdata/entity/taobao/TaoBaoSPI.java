package com.rookie.bigdata.entity.taobao;

import java.io.Serializable;

/**
 * @Class TaoBaoSPI
 * @Description TaoBaoSPI
 * @Author rookie
 * @Date 2023/5/25 17:55
 * @Version 1.0
 */
public class TaoBaoSPI implements Serializable {

    private String serviceUrl;




    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}

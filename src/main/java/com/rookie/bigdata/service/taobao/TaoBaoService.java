package com.rookie.bigdata.service.taobao;

import com.rookie.bigdata.entity.taobao.TaoBaoSPI;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Class TaoBaoService
 * @Description TaoBaoService
 * @Author rookie
 * @Date 2023/5/26 10:34
 * @Version 1.0
 */
public interface TaoBaoService {


    String queryCrmOrder(String shopCode, Long tid) throws ApiException;


}

package com.rookie.bigdata.service.taobao;

import com.rookie.bigdata.service.taobao.impl.TaoBaoSpiServiceImpl;

import java.util.Map;

/**
 * @Class TaoBaoSpiService
 * @Description taoBaoSPI service
 * @Author rookie
 * @Date 2023/5/26 9:58
 * @Version 1.0
 */
public interface TaoBaoSpiService {


     Map<String, TaoBaoOrderOuidService> getMapOrderOuidTaoBaoService() ;


//     void setMapOrderOuidTaoBaoService(Map<String, TaoBaoOrderOuidService> mapOrderOuidTaoBaoService) {
//
//    }

}

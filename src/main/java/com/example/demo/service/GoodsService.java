package com.example.demo.service;

import com.example.demo.dto.GoodsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    String appRunType;

    public GoodsService(@Value("default") String appRunType) { this.appRunType = appRunType; }

    public GoodsDto getGoodsByGoodsNo(String goodsNo) {

        GoodsDto goodsDto = GoodsDto.builder()
                .goodsNo(goodsNo)
                .goodsName("goods-" + appRunType + "-"+goodsNo)
                .build();

        return goodsDto;
    }
}

package com.example.demo.service;

import com.example.demo.dto.GoodsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoodsService {

    private final RestTemplate restTemplate;
    private final String goodsServiceUrl;

    public GoodsService(@Value("${goods.service.url}") String goodsServiceUrl, RestTemplate restTemplate) {
        this.goodsServiceUrl = goodsServiceUrl;
        this.restTemplate = restTemplate;
    }

    public GoodsDto getGoodsByGoodsNo(String goodsNo) {
        String url = goodsServiceUrl + "/api/v1/goods/" + goodsNo;
        return restTemplate.getForObject(url, GoodsDto.class);
    }

}

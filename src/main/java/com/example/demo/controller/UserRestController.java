package com.example.demo.controller;

import com.example.demo.dto.GoodsDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserGoodsDto;
import com.example.demo.service.GoodsService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.example.demo.controller
 * fileName       : UserRestController
 * author         : doong2s
 * date           : 2025. 1. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 1. 12.        doong2s       최초 생성
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/{userNo}")
    public ResponseEntity<UserGoodsDto> getUserByUserNo(@PathVariable String userNo) {
        UserDto userDto = userService.getUserByuserNo(userNo);

        GoodsDto goodsDto = goodsService.getGoodsByGoodsNo(userNo);

        UserGoodsDto userGoodsDto = UserGoodsDto.builder()
                .userNo(userDto.getUserNo())
                .userName(userDto.getUserName())
                .goodsNo(goodsDto.getGoodsNo())
                .goodsName(goodsDto.getGoodsName())
                .build();

        return ResponseEntity.ok(userGoodsDto);
    }
}

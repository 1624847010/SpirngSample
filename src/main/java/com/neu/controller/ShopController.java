package com.neu.controller;


import com.neu.service.ShopService;
import com.neu.util.BaseResponse;
import com.neu.vo.Shop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "商品管理")
@RestController
@RequestMapping("/goods")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/getGoodsList")
    @ApiOperation(value = "查询所有商品")
    public ResponseEntity<BaseResponse<Shop>> getGoodsList(@RequestBody Shop shop){
        try {
            List<Shop> list =shopService.getGoodsList(shop);
            return BaseResponse.generateOKListResponseEntity(list);
        }catch (Exception e){
            return BaseResponse.generateBadResponseEntity(500,"查询失败","");
        }
    }
    @PostMapping("/addGoods")
    @ApiOperation(value = "新增商品")
    public ResponseEntity<BaseResponse<Shop>> addGoods(@RequestBody Shop shop){
        if (shopService.addGoods(shop) != 1) {
            return BaseResponse.generateBadResponseEntity(500,"新增失败","");
        }
        return BaseResponse.generateOKResponseEntity("新增成功");
    }
    @PostMapping("/delGoods")
    @ApiOperation(value = "删除商品")
    public ResponseEntity<BaseResponse<Shop>> delGoods(@RequestBody Shop shop){
        if (shopService.delGoods(shop) != 1) {
            return BaseResponse.generateBadResponseEntity(500,"删除失败","");
        }
        return BaseResponse.generateOKResponseEntity("删除成功");
    }
    @PostMapping("/updateGoods")
    @ApiOperation(value = "修改商品")
    public ResponseEntity<BaseResponse<Shop>> updateGoods(@RequestBody Shop shop){
        if (shopService.updateGoods(shop) != 1) {
            return BaseResponse.generateBadResponseEntity(500,"修改失败","");
        }
        return BaseResponse.generateOKResponseEntity("修改成功");
    }
}

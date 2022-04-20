package com.example.mmykbuyer.controller;

import com.example.mmykbuyer.entity.Buyer;
import com.example.mmykbuyer.param.*;
import com.example.mmykbuyer.service.BuyerService;
import com.example.mmykbuyer.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "买家")
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @ApiOperation("测试")
    @GetMapping(value = "/test")
    public Map<String, String> prod(String storeId, String token) {
        System.out.println(storeId + ":" + token);
        Map<String, String> map = new HashMap<>();
        map.put("storeId", storeId);
        map.put("token", token);
        return map;
    }

    @ApiOperation("创建站点")
    @PostMapping(value = "/createBuyer")
    public ResponseVO prod(@Validated @RequestBody CreateBuyerParam param) {
        buyerService.createBuyer(param);
        return ResponseVO.ok();
    }

    @ApiOperation("更新站点")
    @PostMapping(value = "/updateBuyer")
    public ResponseVO prod(@Validated @RequestBody UpdateBuyerParam param) {
        buyerService.updateBuyer(param);
        return ResponseVO.ok();
    }

    @ApiOperation("删除站点")
    @PostMapping(value = "/deleteBuyer")
    public ResponseVO prod(@Validated @RequestBody DeleteBuyerParam param) {
        buyerService.deleteBuyer(param);
        return ResponseVO.ok();
    }

    @ApiOperation("获取站点详情")
    @PostMapping(value = "/getBuyer")
    public ResponseVO<Buyer> prod(@Validated @RequestBody GetBuyerParam param) {
        Buyer buyer = buyerService.getBuyer(param);
        return ResponseVO.ok(buyer);
    }

    @ApiOperation("获取站点列表")
    @PostMapping(value = "/listBuyer")
    public ResponseVO<Page<Buyer>> prod(@Validated @RequestBody ListBuyerParam param) {
        Page<Buyer> page = buyerService.listBuyer(param);
        return ResponseVO.ok(page);
    }

}

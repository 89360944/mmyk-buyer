package com.example.mmykbuyer.controller;

import com.example.mmykbuyer.entity.Buyer;
import com.example.mmykbuyer.param.*;
import com.example.mmykbuyer.service.BuyerService;
import com.example.mmykbuyer.vo.ResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Tag(name = "站点--Buyer")
@RestController
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/test")
    public String test(HttpServletRequest request){
        return "t hello world, uri:" + request.getRequestURI();
    }

    @GetMapping("/buyer-service/test")
    public String test2(HttpServletRequest request){
        return "uto hello world, uri:" + request.getRequestURI();
    }

    @Operation(summary = "创建站点")
    @PostMapping(value = "/createBuyer")
    public ResponseVO prod(@Validated @RequestBody CreateBuyerParam param) {
        buyerService.createBuyer(param);
        return ResponseVO.ok();
    }

    @Operation(summary = "更新站点")
    @PostMapping(value = "/updateBuyer")
    public ResponseVO prod(@Validated @RequestBody UpdateBuyerParam param) {
        buyerService.updateBuyer(param);
        return ResponseVO.ok();
    }

    @Operation(summary = "删除站点")
    @PostMapping(value = "/deleteBuyer")
    public ResponseVO prod(@Validated @RequestBody DeleteBuyerParam param) {
        buyerService.deleteBuyer(param);
        return ResponseVO.ok();
    }

    @Operation(summary = "获取站点详情")
    @PostMapping(value = "/getBuyer")
    public ResponseVO<Buyer> prod(@Validated @RequestBody GetBuyerParam param) {
        Buyer buyer = buyerService.getBuyer(param);
        return ResponseVO.ok(buyer);
    }

    @Operation(summary = "获取站点列表")
    @PostMapping(value = "/listBuyer")
    public ResponseVO<Page<Buyer>> prod(@Validated @RequestBody ListBuyerParam param) {
        Page<Buyer> page = buyerService.listBuyer(param);
        return ResponseVO.ok(page);
    }

}

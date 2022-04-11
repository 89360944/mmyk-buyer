package com.example.mmykbuyer.service;

import com.example.mmykbuyer.entity.Buyer;
import com.example.mmykbuyer.param.*;
import org.springframework.data.domain.Page;

public interface BuyerService {

    Long createBuyer(CreateBuyerParam param);

    void updateBuyer(UpdateBuyerParam param);

    void deleteBuyer(DeleteBuyerParam param);

    Buyer getBuyer(GetBuyerParam param);

    Page<Buyer> listBuyer(ListBuyerParam param);

}

package com.example.mmykbuyer.service.impl;

import com.example.mmykbuyer.entity.Buyer;
import com.example.mmykbuyer.exception.MyException;
import com.example.mmykbuyer.param.*;
import com.example.mmykbuyer.repository.BuyerRepository;
import com.example.mmykbuyer.service.BuyerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public Long createBuyer(CreateBuyerParam param) {
        Buyer buyer = new Buyer();
        BeanUtils.copyProperties(param, buyer);
        buyerRepository.save(buyer);
        return buyer.getId();
    }

    @Override
    public void updateBuyer(UpdateBuyerParam param) {
        Buyer buyer = new Buyer();
        buyer.setId(param.getId());
        buyer = buyerRepository.findOne(Example.of(buyer)).orElseThrow(() -> new MyException("买家未找到"));
        BeanUtils.copyProperties(param, buyer);
        buyerRepository.save(buyer);
    }

    @Override
    public void deleteBuyer(DeleteBuyerParam param) {
        if (param.getIds().size() > 0) {
            buyerRepository.deleteAllByIdInBatch(param.getIds());
        }
    }

    @Override
    public Buyer getBuyer(GetBuyerParam param) {
        Buyer buyer = new Buyer();
        if (param.getId() != null) {
            buyer.setId(param.getId());
        }
        buyer = buyerRepository.findOne(Example.of(buyer)).orElseThrow(() -> new MyException("买家未找到"));
        return buyer;
    }

    @Override
    public Page<Buyer> listBuyer(ListBuyerParam param) {
        Pageable pageable = PageRequest.of(param.getPageNum() - 1, param.getPageSize(), Sort.by(Sort.Direction.valueOf(param.getSortOrder()), param.getSortField()));
        Page<Buyer> page = buyerRepository.findAll((root, criteriaQuery, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (StringUtils.isNotBlank(param.getUsername())) {
                predicateList.add(cb.like(root.get("username"), "%" + param.getUsername() + "%"));
            }

            Predicate[] pre = new Predicate[predicateList.size()];
            return cb.and(predicateList.toArray(pre));
        }, pageable);
        return page;
    }

}

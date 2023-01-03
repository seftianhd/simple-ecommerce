package com.practice.ecommerce.service;

import com.practice.ecommerce.dao.SellRepository;
import com.practice.ecommerce.entity.SellDetail;
import com.practice.ecommerce.entity.Sell;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SellService {
    @Autowired
    SellRepository sellRepository;

    public Sell saveSellTransaction(Sell sell){
        for (SellDetail sellDetail : sell.getSellDetails()){
            sellDetail.setSell(sell);
        }
        sell.setSellDetails(sell.getSellDetails());
        return sellRepository.save(sell);
    }

    public Iterable<Sell> findAllSell(){
        return sellRepository.findAll();
    }
}
package com.netcracker.service;

import com.netcracker.model.Buyer;

import java.util.List;

public interface IBuyerService {
    void  saveBuyer(Buyer entity);
    List<Buyer> getAllBuyers();
    Buyer getBuyerByID(int id);
    void deleteAllBuyers();
    void deleteByID(int id);
    Long countBuyers();

}

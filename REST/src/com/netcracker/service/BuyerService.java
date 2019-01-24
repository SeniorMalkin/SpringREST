package com.netcracker.service;

import com.netcracker.dao.IBuyerDao;
import com.netcracker.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("buyerService")
public class BuyerService implements IBuyerService {
    @Autowired
    IBuyerDao dao;

    public void saveBuyer(Buyer entity) {
        dao.save(entity);
    }

    public List<Buyer> getAllBuyers() {
        return dao.getAll();
    }

    public Buyer getBuyerByID(int id) {
        return dao.findById(id);
    }

    public void deleteAllBuyers() {
        dao.deleteAll();
    }

    public void deleteByID(int id) {
        dao.deleteById(id);
    }

    public Long countBuyers() {
        return dao.countRec();
    }
}

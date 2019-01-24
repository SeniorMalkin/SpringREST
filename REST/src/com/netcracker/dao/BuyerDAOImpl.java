package com.netcracker.dao;

import com.netcracker.model.Buyer;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("buyerDAO")
@Transactional
public class BuyerDAOImpl extends BasicDAO<Buyer> implements IBuyerDao {

}

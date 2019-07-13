package edu.mum.wap.dao.impl;

import edu.mum.wap.dao.MockData;
import edu.mum.wap.dao.ProductDAO;
import edu.mum.wap.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> findAllProducts() {
        return new ArrayList<>(MockData.productDB.values());
    }

    @Override
    public List<Product> findBestSellerProducts() {
        return new ArrayList<>(MockData.productDB.values());
    }
}

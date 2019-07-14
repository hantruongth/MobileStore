package edu.mum.wap.dao;

import edu.mum.wap.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductDAO {
    List<Product> findAllProducts();
    List<Product> findBestSellerProducts();
    Map<Integer, Product> getProductDB();
    Product getProductDetailsById(int id);
}

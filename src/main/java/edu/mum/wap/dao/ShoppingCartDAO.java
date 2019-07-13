package edu.mum.wap.dao;

import edu.mum.wap.model.Product;

public interface ShoppingCartDAO {
    void addToCart(Product product);
    void removeFromCart(Product product);
}

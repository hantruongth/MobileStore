package edu.mum.wap.dao;

import edu.mum.wap.model.Product;
import edu.mum.wap.model.ShoppingCart;

public interface ShoppingCartDAO {
    void addToCart(int id);
    void removeFromCart(int product);
    void setCart(ShoppingCart cart);
    ShoppingCart getCart();
}

package edu.mum.wap.dao.impl;

import edu.mum.wap.dao.ProductDAO;
import edu.mum.wap.dao.ShoppingCartDAO;
import edu.mum.wap.model.CartItem;
import edu.mum.wap.model.Product;
import edu.mum.wap.model.ShoppingCart;

public class ShoppingCartDAOImpl implements ShoppingCartDAO {

    private ProductDAO productDAO = new ProductDAOImpl();

    private ShoppingCart shoppingCart = new ShoppingCart();

    @Override
    public void addToCart(int id) {

        Product item = productDAO.getProductDB().get(id);
        shoppingCart.getItems().add(new CartItem(item, item.getPrice(), 1));
    }

    @Override
    public void removeFromCart(int product) {

    }

    @Override
    public void setCart(ShoppingCart cart) {
        this.shoppingCart = cart;
    }

    @Override
    public ShoppingCart getCart() {
        return this.shoppingCart;

    }
}

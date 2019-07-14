package edu.mum.wap.dao.impl;

import edu.mum.wap.dao.ProductDAO;
import edu.mum.wap.dao.ShoppingCartDAO;
import edu.mum.wap.model.CartItem;
import edu.mum.wap.model.Product;
import edu.mum.wap.model.ShoppingCart;

import java.util.List;

public class ShoppingCartDAOImpl implements ShoppingCartDAO {

    private ProductDAO productDAO = new ProductDAOImpl();

    private ShoppingCart shoppingCart = new ShoppingCart();

    @Override
    public void addToCart(int id) {

        Product item = productDAO.getProductDB().get(id);
        List<CartItem> cartItems = shoppingCart.getItems();
        boolean addDuplicatedItem = false;

        for(CartItem e: cartItems){
            if(e.getItem() == item) {
                e.setQuantity(e.getQuantity() + 1);
                addDuplicatedItem = true;
            }
        }
        if(!addDuplicatedItem)
            shoppingCart.getItems().add(new CartItem(item, item.getPrice(), 1));
    }

    @Override
    public void removeFromCart(int product) {

    }

    @Override
    public void setCart(ShoppingCart cart) {
        if(cart != null)
            this.shoppingCart = cart;
        else
            this.shoppingCart = new ShoppingCart();
    }

    @Override
    public ShoppingCart getCart() {
        return this.shoppingCart;

    }
}

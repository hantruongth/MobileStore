package edu.mum.wap.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public ShoppingCart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getTotalPrice() {
       return this.items.stream().mapToDouble(e->e.getPrice()).sum();
    }

    public int getNumberOfItems() {
        return items.size();
    }


}

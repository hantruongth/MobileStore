package edu.mum.wap.model;

import java.util.List;

public class ShoppingCart {

    private List<CartItem> items;
    private double totalPrice;
    private int quantity;

    public ShoppingCart() {
    }

    public ShoppingCart(List<CartItem> items, double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return items.size();
    }
}

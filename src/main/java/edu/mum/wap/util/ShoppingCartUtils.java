package edu.mum.wap.util;

import edu.mum.wap.model.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShoppingCartUtils {
    public static final ShoppingCart getShoppingCart(HttpServletRequest req){
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("shoppingCart") != null)
            return (ShoppingCart) session.getAttribute("shoppingCart");
        return null;


    }
}

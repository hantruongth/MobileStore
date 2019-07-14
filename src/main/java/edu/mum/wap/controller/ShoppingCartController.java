package edu.mum.wap.controller;

import com.google.gson.Gson;
import edu.mum.wap.dao.ShoppingCartDAO;
import edu.mum.wap.dao.impl.ShoppingCartDAOImpl;
import edu.mum.wap.model.CartItem;
import edu.mum.wap.model.ShoppingCart;
import edu.mum.wap.util.ShoppingCartUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCartController extends HttpServlet {

    private ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("shoppingCart", ShoppingCartUtils.getShoppingCart(req));
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer productId = Integer.parseInt(req.getParameter("id"));
        ShoppingCart shoppingCart = ShoppingCartUtils.getShoppingCart(req);
        shoppingCartDAO.setCart(shoppingCart);
        shoppingCartDAO.addToCart(productId);
        HttpSession session = req.getSession(true);
        session.setAttribute("shoppingCart", shoppingCartDAO.getCart());
        resp.getWriter().write(String.valueOf(shoppingCartDAO.getCart().getNumberOfItems()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("shopping-cart.jsp");
        shoppingCartDAO.setCart(ShoppingCartUtils.getShoppingCart(req));
        req.setAttribute("cartItems", shoppingCartDAO.getCart().getItems());
        req.setAttribute("totalPrice", shoppingCartDAO.getCart().getTotalPrice());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ShoppingCart shoppingCart = ShoppingCartUtils.getShoppingCart(req);

        String ids = req.getParameter("ids");
        String action = req.getParameter("action");
        Map<String, String> mapProductIdQuantity = (Map<String, String>) new Gson().fromJson(req.getReader(), Object.class);

        List<Integer> productIds = Arrays.stream(ids.split(",")).filter(e -> !e.isEmpty()).map(Integer::new).collect(Collectors.toList());

        List<CartItem> cartItems = shoppingCart.getItems();

        if ("remove".equals(action)) {
            cartItems = cartItems.stream().filter(e -> !productIds.contains(e.getItem().getProductId())).collect(Collectors.toList());
            shoppingCart.setItems(cartItems);
        } else if ("update".equals(action)) {
            cartItems.stream().filter(e -> productIds.contains(e.getItem().getProductId())).forEach(e -> {
                Integer newQuantity = Integer.valueOf(mapProductIdQuantity.get(String.valueOf(e.getItem().getProductId())));
                e.setQuantity(newQuantity);
            });
        }
        HttpSession session = req.getSession(true);
        shoppingCartDAO.setCart(shoppingCart);
        session.setAttribute("shoppingCart", shoppingCartDAO.getCart());
    }
}

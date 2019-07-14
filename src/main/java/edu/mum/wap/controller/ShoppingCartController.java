package edu.mum.wap.controller;

import com.google.gson.Gson;
import edu.mum.wap.dao.ShoppingCartDAO;
import edu.mum.wap.dao.impl.ShoppingCartDAOImpl;
import edu.mum.wap.model.CartItem;
import edu.mum.wap.model.ShoppingCart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCartController extends HttpServlet {

    private ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAOImpl();
    private ShoppingCart shoppingCart;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        if (session != null && session.getAttribute("shoppingCart") != null) {
            shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
            shoppingCartDAO.setCart(shoppingCart);
        } else {
            session.setAttribute("shoppingCart", shoppingCart);
        }
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer productId = Integer.parseInt(req.getParameter("id"));
        shoppingCartDAO.addToCart(productId);
        HttpSession session = req.getSession(true);
        session.setAttribute("shoppingCart", shoppingCartDAO.getCart());
        resp.getWriter().write(String.valueOf(shoppingCartDAO.getCart().getNumberOfItems()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("shopping-cart.jsp");
        req.setAttribute("cartItems", shoppingCartDAO.getCart().getItems());
        req.setAttribute("totalPrice", shoppingCartDAO.getCart().getTotalPrice());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        if (session != null && session.getAttribute("shoppingCart") != null) {
            shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

            String ids = req.getParameter("ids");
            String action = req.getParameter("action");
            Map<String, String> mapProductIdQuantity = (Map<String, String>)new Gson().fromJson(req.getReader(), Object.class);

            List<Integer> productIds = Arrays.stream(ids.split(",")).filter(e->!e.isEmpty()).map(Integer::new).collect(Collectors.toList());

            List<CartItem> cartItems = shoppingCart.getItems();

            if("remove".equals(action)) {
                cartItems = cartItems.stream().filter(e -> !productIds.contains(e.getItem().getProductId())).collect(Collectors.toList());
                shoppingCart.setItems(cartItems);
            }else if("update".equals(action)){
                cartItems.stream().filter(e->productIds.contains(e.getItem().getProductId())).forEach(e-> {
                    Integer newQuantity = Integer.valueOf(mapProductIdQuantity.get(String.valueOf(e.getItem().getProductId())));
                    e.setQuantity(newQuantity);
                });
            }
            shoppingCartDAO.setCart(shoppingCart);
            session.setAttribute("shoppingCart", shoppingCartDAO.getCart());
        }
    }
}

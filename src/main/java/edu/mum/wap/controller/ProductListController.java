package edu.mum.wap.controller;

import edu.mum.wap.dao.ProductDAO;
import edu.mum.wap.dao.impl.ProductDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductListController extends HttpServlet {

    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productDAO.findAllProducts());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product.jsp");
        requestDispatcher.forward(req, resp);
    }
}

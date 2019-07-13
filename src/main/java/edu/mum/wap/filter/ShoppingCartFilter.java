package edu.mum.wap.filter;

import edu.mum.wap.model.ShoppingCart;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"*"})
public class ShoppingCartFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

        HttpSession httpSession =httpServletRequest.getSession();
        ShoppingCart shoppingCart = (ShoppingCart)httpSession.getAttribute("shoppingCart");
        if(shoppingCart != null){
            servletRequest.setAttribute("numItems", shoppingCart.getNumberOfItems());
        }else
            servletRequest.setAttribute("numItems", 0);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

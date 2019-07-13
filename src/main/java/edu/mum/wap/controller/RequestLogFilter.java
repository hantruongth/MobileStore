package edu.mum.wap.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Instant;

public class RequestLogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Instant start = Instant.now();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        HttpServletResponse resp = (HttpServletResponse) response;

        //TODO (TUYEN):
//        if(req.getSession()!= null && req.getSession().getAttribute("user_info") != null){
//            chain.doFilter(request,response);
//        }
//        else{
//            ((HttpServletRequest) request).getSession().setAttribute("err_msg", "You need to log in first.");
//            resp.sendRedirect("login.jsp");
//        }
        chain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
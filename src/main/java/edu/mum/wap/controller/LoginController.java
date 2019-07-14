package edu.mum.wap.controller;

import edu.mum.wap.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public LoginController() {

    }

    @Override
    public void init() throws ServletException {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = "";
        String password = "";

        if(req.getCookies() != null) {
            for (Cookie c : req.getCookies())
                if ("username".equals(c.getName()))
                    username = c.getValue();
                else if ("password".equals(c.getName()))
                    password = c.getValue();
        }
        if (!username.isEmpty() && !password.isEmpty())
        {
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("remember", "checked");
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        UserDAO userDAO = (UserDAO)getServletContext().getAttribute("userDAO");

        if(userDAO.checkExistUser(username, password)){
            req.getSession().setAttribute("user_info" , username);
            if("yes".equals(remember)){
                Cookie cookieUsername = new Cookie("username", username);
                cookieUsername.setMaxAge(3600);
                Cookie cookiePassword = new Cookie("password", password);
                cookiePassword.setMaxAge(3600);
                resp.addCookie(cookieUsername);
                resp.addCookie(cookiePassword);
            }
            else{
                Cookie cookieUsername = new Cookie("username", null);
                cookieUsername.setMaxAge(-1);
                Cookie cookiePassword = new Cookie("password", null);
                cookiePassword.setMaxAge(-1);
                resp.addCookie(cookieUsername);
                resp.addCookie(cookiePassword);
            }
            resp.sendRedirect("/");

        }
        else{
            req.setAttribute("err_msg", "Incorrect username or password");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }
}

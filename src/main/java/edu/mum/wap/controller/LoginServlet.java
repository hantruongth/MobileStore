package edu.mum.wap.controller;

import com.google.gson.Gson;
import edu.mum.wap.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/login", ""})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDAO userDAO;
    //Gson mapper = new Gson();

    public LoginServlet() {

    }

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("logintemp.jsp").forward(req,resp);

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
        if(userDAO.checkExistUser(username, password)){
            req.getSession().setAttribute("user_info" , username);
            //if(req.getParameter("remember") != null && req.getParameter("remember").equals("yes")){
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
                cookieUsername.setMaxAge(0);
                Cookie cookiePassword = new Cookie("password", null);
                cookiePassword.setMaxAge(0);
                resp.addCookie(cookieUsername);
                resp.addCookie(cookiePassword);
            }
            //NEED TO DO
            resp.sendRedirect("mobiles.jsp");//To be modified to mobile list

        }else{
            req.setAttribute("err_msg", "Incorrect username or password");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

        }
}

package edu.mum.wap.controller;

import com.google.gson.Gson;
import edu.mum.wap.dao.UserDAO;
import edu.mum.wap.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        User user = mapper.fromJson(req.getParameter("userNew"), User.class);

        UserDAO userDAO = (UserDAO)getServletContext().getAttribute("userDAO");

        String password = user.getPassword();
        if (userDAO.addUser(user.getUserName(), password, user.getFullName(), user.getEmail(), user.getAddress(), user.getPhone())) {
            Cookie cookieUsername = new Cookie("username", user.getUserName());
            cookieUsername.setMaxAge(3600);
            Cookie cookiePassword = new Cookie("password", user.getPassword());
            cookiePassword.setMaxAge(3600);
            resp.addCookie(cookieUsername);
            resp.addCookie(cookiePassword);
            req.getSession().setAttribute("user_info", user.getUserName());
            //req.getSession().setAttribute("username_label", user.getUserName());
        } else {
            user.setUserName("");
        }
        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(user));
    }
}

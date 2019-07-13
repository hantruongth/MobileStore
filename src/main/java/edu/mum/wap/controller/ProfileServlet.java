package edu.mum.wap.controller;

import edu.mum.wap.dao.UserDAO;
import edu.mum.wap.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getSession().getAttribute("user_info").toString();

        UserDAO userDAO = (UserDAO)getServletContext().getAttribute("userDAO");
        User user = userDAO.getUserByUsername(userName);
        if(user != null)
        {
            req.setAttribute("user", user);
        }
        else
        {
            req.setAttribute("error_profile", "Can not get the user's profile.");
        }
        req.getRequestDispatcher("profile.jsp").forward(req,resp);
    }
}

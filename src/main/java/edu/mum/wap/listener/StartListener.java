package edu.mum.wap.listener;

import edu.mum.wap.dao.UserDAO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener()
public class StartListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserDAO userDAO = new UserDAO();
        servletContextEvent.getServletContext().setAttribute("userDAO", userDAO);
    }
}

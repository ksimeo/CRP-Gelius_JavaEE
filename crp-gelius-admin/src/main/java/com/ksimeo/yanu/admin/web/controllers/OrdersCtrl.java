package com.ksimeo.yanu.admin.web.controllers;

import com.ksimeo.yanu.entities.models.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Ksimeo. Created on 08.10.2016 at 21:23 for "untitled" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/orders.do")
public class OrdersCtrl extends HttpServlet {
    //Инициализация логера
    private static final Logger log = Logger.getLogger(OrdersCtrl.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String login = user.getLogin();
        req.setAttribute("usrlogin", login);
        //TODO
        req.getRequestDispatcher("/WEB-INF/orders.jsp").forward(req, resp);
    }
}

package com.ksimeo.yanu.admin.controllers;

import com.ksimeo.yanu.entities.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Ksimeo. Created on 08.10.2016 at 21:36 for "untitled" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/delplan.do")
public class PlanDelCtrl extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String login = user.getLogin();
        req.setAttribute("usrlogin", login);
        //TODO
        req.getRequestDispatcher("/WEB-INF/plans.jsp").forward(req, resp);
    }
}

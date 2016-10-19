package com.ksimeo.yanu.admin.controllers;

import com.ksimeo.yanu.api.services.UsersService;
import com.ksimeo.yanu.entities.models.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Данный сервлет обрабатывает запрос пользователя для попадания на главную страницу администратора системы
 *
 *
 * @author Ksimeo. Created on 08.10.2016 at 19:57 for "untitled" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/admin.do")
public class AdminCtrl extends HttpServlet {
    @Autowired
    private UsersService usrServ;

    //Инициализация логера
    private static final Logger log = Logger.getLogger(AdminCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
        log.info("Начало работы.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        try {
            String login = user.getLogin();
            req.setAttribute("usrlogin", login);
            List<User> users = usrServ.getUsers();
            if (users != null) {
                req.setAttribute("users", users);
                req.setAttribute("substitute", "hidden");
            } else {
                req.setAttribute("tablevision", "hidden");
            }
            req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

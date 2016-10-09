package com.ksimeo.yanu.customers.controllers.commons;

import com.ksimeo.yanu.api.services.UsersService;
import com.ksimeo.yanu.entities.models.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Ksimeo. Created on 09.10.2016 at 15:03 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/login")
public class LogInCtrl extends HttpServlet {
    @Autowired
    private UsersService usrServ;
//    = new UsersServImpl();
    //logger initialization
    private static final Logger log = Logger.getLogger(LogInCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            User usr = usrServ.getUser(login, password);
            if (usr != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", usr);
                session.setMaxInactiveInterval(30 * 60);
                String name = usr.getLogin();
                Cookie userLogin = new Cookie("user", name);
                userLogin.setMaxAge(30 * 60);
                resp.addCookie(userLogin);
                int role = usr.getRole();
                switch (role) {
                    case 0:
                        resp.sendRedirect("/admin.do");
                        break;
                    case 1:
                        resp.sendRedirect("/manager.do");
                        break;
                    case 2:
                        resp.sendRedirect("/planner.do");
                        break;
                    case 3:
                        resp.sendRedirect("/taiwanese.do");
                        break;
                    case 4:
                        resp.sendRedirect("/bobst.do");
                        break;
                    case 5:
                        resp.sendRedirect("/packaging.do");
                        break;
                    case 6:
                        resp.sendRedirect("/storage.do");
                        break;
                    default:
                        req.setAttribute("error", "Статус пользователя неопределен!");
                        req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("error", "Вы ввели неверный логин или(и) пароль!");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Сервис временно недоступен. Попробуйте зайти позже или обратитесь" +
                    " в службу поддержки.");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}

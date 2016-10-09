package com.ksimeo.yanu.customers.controllers.storage;

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
 * @author Ksimeo. Created on 17.07.2016 at 9:01 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 *
 * This class processing GET and POST requests from warehouseman-page.
 *
 * Данный класс обрабатывает GET и POST запросы со страницы кладовщика.
 */
@WebServlet(urlPatterns = "/warehouseman.do")
public class WarehousemanCtrl extends HttpServlet {

    private static final Logger log = Logger.getLogger(WarehousemanCtrl.class);

    /**
     * This method readdressing user of system to warehouseman-page which is not available on the straight path.
     *
     * Данный метод переадресовывает пользователя системы на страницу кдадовщика приложения, которая
     * недоступна по прямому пути.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String login = user.getLogin();
        System.out.println("Логин администратора:" + login);
        req.setAttribute("usrlogin", login);
        req.getRequestDispatcher("WEB-INF/warehouseman.jsp").forward(req, resp);
    }
}

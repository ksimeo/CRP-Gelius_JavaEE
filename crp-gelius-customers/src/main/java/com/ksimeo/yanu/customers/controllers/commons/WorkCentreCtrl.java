package com.ksimeo.yanu.customers.controllers.commons;

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
 * @author Ksimeo. Created on 17.07.2016 at 7:46 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 *
 * This class processing GET and POST requests from workcentre page of application.
 *
 * Данный класс обрабатывает GET и POST запросы со страницы рабочего центра.
 */

@WebServlet(urlPatterns = "/workcentre.do")
public class WorkCentreCtrl extends HttpServlet {

    private static final Logger log = Logger.getLogger(WorkCentreCtrl.class);

    /**
     * This method readdressing administrator of system to the page of work centre which
     * is not available on the straight path.
     *
     * Данный метод переадресовывает администратора системы на страницу рабочего центра, которая
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
        req.setAttribute("usrlogin", login);
        req.getRequestDispatcher("/WEB-INF/taiwanese.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
package com.ksimeo.yanu.customers.controllers.manager;

import com.ksimeo.yanu.api.services.OrdersService;
import com.ksimeo.yanu.entities.models.Order;
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
 * @author Ksimeo. Created on 09.10.2016 at 16:23 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/manager.do")
public class ManagersCtrl extends HttpServlet {
    @Autowired
    private OrdersService ordServ;
//    = new OrdersServImpl();
    //initializing logging
    private static final Logger log = Logger.getLogger(ManagersCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
//    }

    /**
     * This method readdressing user of system to manager-page which is not available on the straight path.
     *
     * Данный метод переадресовывает пользователя системы на страницу менеджера, которая
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
        List<Order> orders = ordServ.getActualOrders();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("WEB-INF/manager.jsp").forward(req, resp);
    }
}

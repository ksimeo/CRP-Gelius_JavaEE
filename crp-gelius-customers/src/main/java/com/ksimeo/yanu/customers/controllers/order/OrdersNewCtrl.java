package com.ksimeo.yanu.customers.controllers.order;

import com.ksimeo.yanu.entities.models.Order;
import com.ksimeo.yanu.entities.models.User;
import com.ksimeo.yanu.api.services.OrdersService;
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
 * @author Ksimeo. Created on 27.07.2016 at 12:05 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/neworders.do")
public class OrdersNewCtrl extends HttpServlet {
    @Autowired
    private OrdersService orderServ;

    private static final Logger log = Logger.getLogger(OrdersNewCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String login = user.getLogin();
        req.setAttribute("usrlogin", login);
        List<Order> orders = orderServ.getNewOrders();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("WEB-INF/ordersnew.jsp").forward(req, resp);
    }
}

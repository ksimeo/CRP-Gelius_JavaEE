package com.ksimeo.yanu.customers.controllers.manager;

import com.ksimeo.yanu.entities.models.Order;
import com.ksimeo.yanu.entities.models.Parcel;
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
import java.io.IOException;
import java.util.List;

/**
 * @author Ksimeo. Created on 28.09.2016 at 18:33 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/historymanager.do")
public class ManagerHistoryCtrl extends HttpServlet {
    @Autowired
    private OrdersService orderServ;

    private static final Logger log = Logger.getLogger(ManagerHistoryCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String p = req.getParameter("p");
        if (p != null && p.equals("")) {
            int page = Integer.parseInt(p);
            Parcel<Order> orders = orderServ.getOrderPage(page);
            List<Order> orderPage = orders.getItems();
            req.setAttribute("orders", orderPage);
            req.setAttribute("page", page);
            req.setAttribute("last", orders.isLastPage());
            req.getRequestDispatcher("WEB-INF/manager/history.jsp");
        } else {
            resp.sendRedirect("historymanager.do?p=1");
        }
    }
}

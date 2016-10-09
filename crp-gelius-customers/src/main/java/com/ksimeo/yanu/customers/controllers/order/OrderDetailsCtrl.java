package com.ksimeo.yanu.customers.controllers.order;

import com.ksimeo.yanu.api.services.OrdersService;
import com.ksimeo.yanu.entities.models.Order;
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

/**
 * @author Ksimeo. Created on 12.08.2016 at 13:25 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/orderdetails.do")
public class OrderDetailsCtrl extends HttpServlet {
    @Autowired
    private OrdersService ordServ;

    private static final Logger LOGGER = Logger.getLogger(OrderDetailsCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderID = req.getParameter("orderid");
        String res = "";
        if (orderID != null && !(orderID.equals(""))) {
            int id = Integer.parseInt(orderID);
            Order order = ordServ.getOrder(id);
            res = res + order.getCertificate().getTitle();
            res = res + "\r\nСоздал: " + order.getManager().getName() + " " + order.getManager().getSurname();
            res = res + "\r\nДата создания: " + order.getCreateDate();
            if (order.getPlan() == null) {
                 res = res + ",\n<В ПЛАН НЕ ВКЛЮЧЕНО>";
            } else {
                res = res + ",\r\n" + order.getPlan().getCreateDate();
            }
        }
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(res);
    }
}
package com.ksimeo.yanu.customers.controllers.order;

import com.ksimeo.yanu.entities.models.Order;
import com.ksimeo.yanu.entities.models.User;
import com.ksimeo.yanu.entities.models.Сert;
import com.ksimeo.yanu.api.services.CertificatesService;
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
 * @author Ksimeo. Created on 09.08.2016 at 14:45 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/createorder.do")
public class OrderCreateCtrl extends HttpServlet {
    @Autowired
    private OrdersService orderServ;
    @Autowired
    private CertificatesService certServ;

    private static final Logger log = Logger.getLogger(OrderCreateCtrl.class);

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
        List<Сert> certs = certServ.getCertificates();
        req.setAttribute("certs", certs);
        req.getRequestDispatcher("WEB-INF/ordercreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cert = req.getParameter("certs");
        String quant = req.getParameter("quantity");
        if (cert != null && !(cert.equals("")) && quant != null && !(quant.equals(""))) {
            int certID = Integer.parseInt(cert);
            int quantity = Integer.parseInt(quant);
            Сert c = certServ.getCertificate(certID);
            HttpSession session = req.getSession();
            User usr = (User)session.getAttribute("user");
            Order ord = new Order(c, quantity, usr);
            orderServ.addOrder(ord);
            resp.sendRedirect("/manager.do");
        } else {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            String login = user.getLogin();
            req.setAttribute("usrlogin", login);
            List<Order> orders = orderServ.getNewOrders();
            req.setAttribute("orders", orders);
            List<Сert> certs = certServ.getCertificates();
            req.setAttribute("certs", certs);
            req.setAttribute("error", "Заполнены не все поля!");
            req.getRequestDispatcher("WEB-INF/ordercreate.jsp").forward(req, resp);
        }
    }
}

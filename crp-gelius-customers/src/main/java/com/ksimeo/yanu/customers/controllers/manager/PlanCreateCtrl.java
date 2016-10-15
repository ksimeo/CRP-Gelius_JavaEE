package com.ksimeo.yanu.customers.controllers.manager;

import com.ksimeo.yanu.entities.models.*;
import com.ksimeo.yanu.api.services.OrdersService;
import com.ksimeo.yanu.api.services.PlansService;
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
import java.util.Date;

/**
 * @author Ksimeo. Created on 27.07.2016 at 19:22 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/createplan.do")
public class PlanCreateCtrl extends HttpServlet {
    @Autowired
    private OrdersService orderServ;
    @Autowired
    private PlansService planServ;

    private static final Logger log = Logger.getLogger(PlanCreateCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String login = user.getLogin();
        req.setAttribute("usrlogin", login);
        String orderID = req.getParameter("id");
        req.setAttribute("id", orderID);
        int id = 0;
        if (orderID != null) id = Integer.parseInt(orderID);
        Order order = orderServ.getOrder(id);
        Date orderDate = order.getCreateDate();
        req.setAttribute("orderdate", orderDate);
        String name = order.getManager().getName();
        req.setAttribute("name", name);
        String surname = order.getManager().getSurname();
        req.setAttribute("surname", surname);
        Cert cert = order.getCertificate();
        int certId = cert.getId();
        req.setAttribute("cert_id", certId);
        String title = cert.getTitle();
        req.setAttribute("title", title);
        int quant = order.getQuantity();
        req.setAttribute("quantity", quant);
        req.getRequestDispatcher("WEB-INF/plancreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String orderId = req.getParameter("id");
        HttpSession session = req.getSession();
        User planner = (User)session.getAttribute("user");
        int orderID = 0;
        if (orderId != null && !(orderId.equals(""))) orderID = Integer.parseInt(orderId);
        Order order = orderServ.getOrder(orderID);
        Plan plan = new Plan(planner, order);
        String format = req.getParameter("format");
        System.out.println("Формат: " + format);
        plan.setFormat(format);
        String dens = req.getParameter("density");

        if (dens != null && !(dens.equals(""))) {
            int density = Integer.parseInt(dens);
            System.out.println("Плотность: " + density);
            plan.setDensity(density);
        }
        String lays = req.getParameter("layers");
        if (lays != null && !(lays.equals(""))) {
            int layers = Integer.parseInt(lays);
            System.out.println("Слои: " + layers);
            plan.setLayers(layers);
        }
        String taiwanDate = req.getParameter("taiwandate");
        plan.setTaiwaneseDatePlan(new Date(taiwanDate));
        String taiwanShift = req.getParameter("taiwanshift");
        Shift shift = taiwanShift.equals("day") ? Shift.DAY : Shift.NIGHT;
        plan.setTaiwaneseShiftPlan(shift);
        String bobstDate = req.getParameter("bobstdate");
        plan.setBobstDatePlan(new Date(bobstDate));
        String bobstShift = req.getParameter("bobstshift");
        shift = bobstShift.equals("day") ? Shift.DAY : Shift.NIGHT;
        plan.setBobstShiftPlan(shift);
        String packagingDate = req.getParameter("packagingdate");
        plan.setBobstDatePlan(new Date(packagingDate));
        String packagingShift = req.getParameter("packagingshift");
        shift = bobstShift.equals("day") ? Shift.DAY : Shift.NIGHT;
        plan.setPackagingDatePlan(new Date(packagingDate));
        plan.setPackagingShiftPlan(shift);
        order.setPlan(plan);
        System.out.println("Сохр.плотность: " + plan.getDensity());
        System.out.println("Сохр.кол.слоев: " + plan.getLayers());
        planServ.addPlan(plan);
        resp.sendRedirect("planner.do");
    }
}

package com.ksimeo.yanu.customers.controllers.plan;

import com.ksimeo.yanu.entities.models.Plan;
import com.ksimeo.yanu.entities.models.User;
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
import java.util.List;

/**
 * @author Ksimeo. Created on 17.07.2016 at 8:52 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 *
 * This class processing GET and POST requests from planner-page of application.
 *
 * Данный класс обрабатывает GET и POST запросы со страницы планировщика приложения.
 */
@WebServlet(urlPatterns = "/planner.do")
public class PlannerCtrl extends HttpServlet {
    @Autowired
    private OrdersService orderServ;
    @Autowired
    private PlansService planServ;

    private static final Logger log = Logger.getLogger(PlannerCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    /**
     * This method readdressing user of system to planner-page which is not available on the straight path.
     *
     * Данный метод переадресовывает пользователя системы на страницу планировщика приложения, которая
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
        int ordersCount = orderServ.getNewOrders().size();
        List<Plan> plans = planServ.getActualPlans();
        req.setAttribute("plans", plans);
        req.setAttribute("newordercount", ordersCount);
        req.getRequestDispatcher("WEB-INF/planner.jsp").forward(req, resp);
    }
}

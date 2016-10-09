package com.ksimeo.yanu.customers.controllers.taiwanese;

import com.ksimeo.yanu.entities.models.Plan;
import com.ksimeo.yanu.entities.models.User;
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
 * @author Ksimeo. Created on 10.09.2016 at 15:08 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/taiwaneselog.do")
public class TaiwaneseLogCtrl extends HttpServlet {
    @Autowired
    private PlansService plansServ;

    private static final Logger log = Logger.getLogger(TaiwaneseLogCtrl.class);

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
        String p = req.getParameter("p");
        if (p != null && p.equals("")) {
            int page = Integer.parseInt(p);
            List<Plan> plans = plansServ.getPlans();
            req.setAttribute("plans", plans);
        }
    }
}

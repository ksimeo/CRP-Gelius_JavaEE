package com.ksimeo.yanu.customers.controllers.taiwanese;

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
import java.io.IOException;

/**
 * @author Ksimeo. Created on 31.08.2016 at 19:28 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/parttaiwandone.do")
public class TaiwanDoneCtrl extends HttpServlet {
    @Autowired
    private PlansService planServ;

    private static final Logger log = Logger.getLogger(TaiwanDoneCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("planid");
        String q = req.getParameter("quant");
        if (id != null && !(id.equals("")) && q != null && !(q.equals(""))) {
            int planId = Integer.parseInt(id);
            int quant = Integer.parseInt(q);
            int planQuant = planServ.getPlan(planId).getOrder().getQuantity();
            int quantDone = planServ.getPlan(planId).getTaiwanDone();
            quant = quantDone + quant;
            if (quant < planQuant) {
                planServ.getPlan(planId).setTaiwanDone(quant);
                resp.sendRedirect("/taiwanese.do");
            } else if (quant == planQuant) {
                resp.sendRedirect("/alltaiwandone.do?id=" + planId);
            } else {
                req.setAttribute("error", "Вы ввели некорректные данные!");
                req.getRequestDispatcher("WEB-INF/taiwanese.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "Вы ввели некорректные данные!");
            req.getRequestDispatcher("WEB-INF/taiwanese.jsp").forward(req, resp);
        }
    }
}
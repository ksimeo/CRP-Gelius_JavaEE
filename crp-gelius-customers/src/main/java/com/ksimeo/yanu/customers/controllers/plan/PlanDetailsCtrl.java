package com.ksimeo.yanu.customers.controllers.plan;

import com.ksimeo.yanu.entities.models.Plan;
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
 * @author Ksimeo. Created on 19.08.2016 at 20:10 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/plandetails.do")
public class PlanDetailsCtrl extends HttpServlet {
    @Autowired
    private PlansService planServ;

    private static final Logger LOGGER = Logger.getLogger(PlanDetailsCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String planID = req.getParameter("planid");
        System.out.println("Plan Id: " + planID);
        String res = "Нет информации";
        if (planID != null && !(planID.equals(""))) {
            int id = Integer.parseInt(planID);
            Plan currPlan = planServ.getPlan(id);
            res = "Дата создания: " + currPlan.getCreateDate();
            res = res + "\r\nСоздатель: " + currPlan.getPlanner().getName() + " " + currPlan.getPlanner().getSurname();
            res = res + "\r\nСогл. тех. паспорту: №" + currPlan.getOrder().getCertificate().getId() + " " +
                    currPlan.getOrder().getCertificate().getTitle();
            res = res + "\r\nОжидаемая смена Тайванец: " + currPlan.getTaiwaneseDatePlan() + "/" + currPlan.getTaiwaneseShiftPlan();
            res = res + "\r\nФактическая смена Тайванец: " + currPlan.getTaiwaneseDateFact() + "/" + currPlan.getTaiwaneseShiftFact();
            res = res + "\r\nОжидаемая смена Бобст: " + currPlan.getBobstDatePlan() + "/" + currPlan.getBobstShiftPlan();
            res = res + "\r\nФактическая смена Бобст: " + currPlan.getBobstDateFact() + "/" + currPlan.getBobstShiftFact();
            res = res + "\r\nОжидаемая смена Упаковщик: " + currPlan.getPackagingDatePlan() + "/" + currPlan.getPackagingShiftPlan();
            res = res + "\r\nФактическая смена Упаковщик: " + currPlan.getPackagingDatePlan() + "/" + currPlan.getPackagingShiftFact();
            res = res + "\r\nПрибытие на склад: " + currPlan.getStorageDate() + " Отгрузка: " + currPlan.getDepartureDate();
        }
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(res);
    }
}

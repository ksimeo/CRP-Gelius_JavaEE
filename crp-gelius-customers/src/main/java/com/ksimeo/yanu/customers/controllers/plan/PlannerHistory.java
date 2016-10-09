package com.ksimeo.yanu.customers.controllers.plan;


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
 * @author Ksimeo. Created on 28.09.2016 at 19:53 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/plannerhisory.do")
public class PlannerHistory extends HttpServlet {
    @Autowired
    private PlansService plansServ;

    private static final Logger log = Logger.getLogger(PlannerHistory.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

package com.ksimeo.yanu.customers.controllers.certificate;

import com.ksimeo.yanu.api.services.CertificatesService;
import com.ksimeo.yanu.entities.models.User;
import com.ksimeo.yanu.entities.models.Сert;
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
 * @author Ksimeo. Created on 19.07.2016 at 11:43 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 *
 * This class processing GET and POST requests from page of technical certificates.
 *
 * Данный класс обрабатывает GET и POST запросы со страницы технических паспортов.
 */
@WebServlet(urlPatterns = "/certificates.do")
public class CertificatesCtrl extends HttpServlet {
    @Autowired
    private CertificatesService certServ;
    private static final Logger log = Logger.getLogger(CertificatesCtrl.class);

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
        List<Сert> certs = certServ.getCertificates();
        req.setAttribute("certs", certs);
        req.getRequestDispatcher("WEB-INF/certificates.jsp").forward(req, resp);
    }
}

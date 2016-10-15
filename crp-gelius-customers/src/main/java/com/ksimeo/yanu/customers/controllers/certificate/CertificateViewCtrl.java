package com.ksimeo.yanu.customers.controllers.certificate;

import com.ksimeo.yanu.entities.models.Order;
import com.ksimeo.yanu.entities.models.User;
import com.ksimeo.yanu.entities.models.Cert;
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
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author Ksimeo. Created on 20.07.2016 at 19:22 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/certificateview.do")
public class CertificateViewCtrl extends HttpServlet {
    @Autowired
    private CertificatesService certServ;
    @Autowired
    private OrdersService orderServ;


    private static final Logger LOGGER = Logger.getLogger(CertificateViewCtrl.class);


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String certificateID = req.getParameter("id");
        if (certificateID != null) {
            int id = Integer.parseInt(certificateID);
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            String login = user.getLogin();
            req.setAttribute("id", id);
            req.setAttribute("usrlogin", login);
            Cert cert = certServ.getCertificate(id);
            String title = cert.getTitle();
            req.setAttribute("certtitle", title);
            String path = cert.getPath();
            File file = new File(path);
            User author = certServ.getCertificate(id).getCreator();
            String authorName = author.getName();
            String authorSurname = author.getSurname();
            String authorLogin = author.getLogin();
            String authorEmail = author.getEmail();
            req.setAttribute("name", authorName);
            req.setAttribute("surname", authorSurname);
            req.setAttribute("usrlogin", authorLogin);
            req.setAttribute("email", authorEmail);
            String name = file.getName();
            req.setAttribute("filename", name);
            Date date = cert.getRegDate();
            req.setAttribute("certdate", date);
            req.getRequestDispatcher("WEB-INF/certificateview.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Неправильно введенны данные!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String certID = req.getParameter("id");
        String quantity = req.getParameter("quantity");
        if (quantity != null) {
            int id = Integer.parseInt(certID);
            int quant = Integer.parseInt(quantity);
            Cert cert = certServ.getCertificate(id);
            HttpSession session = req.getSession(false);
            User creator = (User) session.getAttribute("user");
            Order order = orderServ.addOrder(new Order(cert, quant, creator));
            resp.sendRedirect("/manager.do");
        } else {
            req.setAttribute("error", "Произошла ошибка при заполнении! Поробуйте, пожалуйста, еще раз.");
            req.getRequestDispatcher("/certificateview.do").forward(req, resp);
        }
    }
}

package com.ksimeo.yanu.customers.controllers.certificate;

import com.ksimeo.yanu.entities.models.User;
import com.ksimeo.yanu.entities.models.Cert;
import com.ksimeo.yanu.api.services.CertificatesService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author Ksimeo. Created on 19.07.2016 at 15:21 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/certificatecreate.do")
public class CertificateCreateCtrl extends HttpServlet {
    @Autowired
    private CertificatesService certServ;

    private static final Logger LOGGER = Logger.getLogger(CertificateCreateCtrl.class);

    private Random random = new Random();
    private File uploadetFile = null;

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
        req.getRequestDispatcher("WEB-INF/certificatecreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
        String title = null;
        // Create path components to save the file
        //final String path = req.getParameter("destination");
        //проверяем является ли полученный запрос multipart/form-data
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (!isMultipart) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // Создаём класс фабрику
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Максимальный буфера данных в байтах,
        // при его привышении данные начнут записываться на диск во временную директорию
        // устанавливаем один мегабайт
        factory.setSizeThreshold(1024*1024);

        // устанавливаем временную директорию
        File tempDir = (File)getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);

        //Создаём сам загрузчик
        ServletFileUpload upload = new ServletFileUpload(factory);

        //максимальный размер данных который разрешено загружать в байтах
        //по умолчанию -1, без ограничений. Устанавливаем 10 мегабайт.
        upload.setSizeMax(1024 * 1024 * 10);

        try {
            List items = upload.parseRequest(req);
            Iterator iter = items.iterator();

            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
                        title = item.getString();
                    //если принимаемая часть данных является полем формы
                    processFormField(item);
                } else {
                    //в противном случае рассматриваем как файл
                     processUploadedFile(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
        String filePath = uploadetFile.getAbsolutePath();
        HttpSession session = req.getSession();
        User currUser = (User) session.getAttribute("user");
//        String userName = user.getName();
//        String userSurname = user.getSurname();
//        String login = user.getLogin();
        certServ.addCertificate(new Cert(title, currUser, filePath));
        resp.sendRedirect("/certificates.do");
    }


    private void processFormField(FileItem item) {
        System.out.println(item.getFieldName()+"="+item.getString());
    }

    private void processUploadedFile(FileItem item) throws Exception {

        //выбираем файлу имя пока не найдём свободное
        do {
            String fileName = item.getName();
            fileName = new String(fileName.getBytes("cp1251"), "UTF-8");
//            String path = getServletContext().getRealPath("upload/" + random.nextInt() + fileName);
            String path = "d://upload_docs//" + random.nextInt() + fileName;
            uploadetFile = new File(path);
        } while(uploadetFile.exists());

        //создаём файл
        uploadetFile.createNewFile();
        //записываем в него данные
        item.write(uploadetFile);
    }
}

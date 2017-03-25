package com.ksimeo.yanu.admin.web.filters;

import com.ksimeo.yanu.entities.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Экземпляр класса данного фильтра безопасности предварительно анализирует запросы поступающие на сервер
 * администрирования и определяет имеет ли пользователь достаточное количество прав для совершение того или
 * иного запроса к система (в противном случае возвращает его обратно на страницу авторизации).
 *
 *
 * @author Ksimeo. Created on 18.10.2016 at 13:15 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@WebFilter(urlPatterns = "/*")
public class SecureFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    /**
     * Данный метод выполняет непосредственно "фильтрование" запросов, в случае "успеха" произойдет передача к следующему
     * фильру в цепочке ответственности, в случае "неудачи" происхдит переадресация на "стартовую" страницу.
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        Cookie[] cookies = req.getCookies();
        boolean isLoggedIn = false;
        User sessionUserAttr = null;
        if (session != null && cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    sessionUserAttr = (User) session.getAttribute("user");
                    if (sessionUserAttr == null) break;
                    isLoggedIn = cookie.getValue().equalsIgnoreCase(sessionUserAttr.getLogin());
                    break;
                }
            }
        }
        String uri = req.getRequestURI();
        if (!isLoggedIn && uri.endsWith("*.do")) resp.sendRedirect("/index.jsp");
        else {
            if (sessionUserAttr != null) {
                if (uri.endsWith("/logout")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (sessionUserAttr.getRole() != 0 && uri.endsWith(".do")) {
                    resp.sendRedirect("/index.jsp");
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}

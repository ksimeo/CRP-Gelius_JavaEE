package com.ksimeo.yanu.entities.gto;

/**
 * @author Ksimeo. Created on 15.10.2016 at 21:10 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public class UserGTO {
    private String login;
    private String password;

    public UserGTO() {
    }

    public UserGTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

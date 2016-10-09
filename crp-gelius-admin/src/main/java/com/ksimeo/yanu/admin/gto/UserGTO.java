package com.ksimeo.yanu.admin.gto;

/**
 * @author Ksimeo. Created on 02.10.2016 at 20:25 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public class UserGTO {
    public String login;
    public String password;
    public String name;
    public String surname;
    public String email;
    public int role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

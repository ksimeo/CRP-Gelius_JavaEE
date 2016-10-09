package com.ksimeo.yanu.entities.models;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Ksimeo. Created on 16.07.2016 at 20:22 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 *
 * This class represented an entity "user" which has one from four roles available in system.
 *
 * Данный класс представляет сущность "Пользователь", который относиться к одной из четырех должностей доступных
 * в системе.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private int role;
    @Column
    private Date regDate;

    public User() {
    }

    public User(String login, String password, int role) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.regDate = new Date();
    }

    public User(int id, String login, String password, int role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.regDate = new Date();
    }

    public User(String login, String password, String name, String surname, String email, int role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.regDate = new Date();
    }

    public User(String login, String password, String name, String surname, int role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.regDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegDate() {
        return regDate;
    }

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

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}

package com.ksimeo.yanu.entities.models;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Ksimeo. Created on 17.07.2016 at 22:21 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name="certificates")
public class Сert {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String title;
    @Column
    private String path;
    @Column
    private User creator;
    @Column(name = "reg_date")
    private Date regDate;

    public Сert() {
        this.regDate = new Date();
    }


    public Сert(String title) {
        this.title = title;
        this.regDate = new Date();
    }

    public Сert(int id, String title, User creator) {
        this.title = title;
        this.creator = creator;
        this.id = id;
    }

    public Сert(String title, User creator, String path) {
        this.title = title;
        this.creator = creator;
        this.path = path;
        this.regDate = new Date();
    }

    public Сert(int id, String title, User creator, String path) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.path = path;
        this.regDate = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

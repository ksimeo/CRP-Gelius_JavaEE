package com.ksimeo.yanu.entities.models;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Ksimeo. Created on 17.07.2016 at 22:26 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    @Column
    @ManyToOne
    private Сert certificate;
    @Column
    @OneToOne
    private Plan plan;
    @Column
    private int quantity;
    @Column
    @OneToMany
    private User manager;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "actual")
    private boolean isActual = true;

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }

    public Order() {
        this.createDate = new Date();
    }

    public Order(Сert certificate, int quantity, User manager) {
        this.certificate = certificate;
        this.quantity = quantity;
        this.manager = manager;
        this.createDate = new Date();
    }

    public Сert getCertificate() {
        return certificate;
    }

    public void setCertificate(Сert certificate) {
        this.certificate = certificate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActual() {
        return isActual;
    }
}

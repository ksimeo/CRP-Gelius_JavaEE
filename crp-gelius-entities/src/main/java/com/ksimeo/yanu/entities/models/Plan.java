package com.ksimeo.yanu.entities.models;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Ksimeo. Created on 17.07.2016 at 22:40 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue
    private int id;
    @Column
    @OneToOne
    private Order order;
    @Column
    private User planner;
    @Column
    private Date createDate;
    @Column
    private Date planDate;
    @Column
    private int shift;
    @Column
    private String format;
    @Column
    private int density;
    @Column
    private int layers;
    @Column(name = "taiwanese_date_plan")
    private Date taiwaneseDatePlan;
    @Column(name = "taiwanese_shift_plan")
    private Shift taiwaneseShiftPlan;
    @Column(name = "taiwan_done")
    private int taiwanDone;
    @Column(name = "taiwanese_date_fact")
    private Date taiwaneseDateFact;
    @Column(name = "taiwanese_shift_fact")
    private Date taiwaneseShiftFact;
    @Column(name = "bobst_date_plan")
    private Date bobstDatePlan;
    @Column(name = "bobst_shift_plan")
    private Shift bobstShiftPlan;
    @Column(name = "bobst_done")
    private int bobstDone;
    @Column(name = "bobst_date_fact")
    private Date bobstDateFact;
    @Column(name = "bobst_shift_plan")
    private Shift bobstShiftFact;
    @Column(name = "packaging_date_plan")
    private Date packagingDatePlan;
    @Column(name = "packaging_shift_plan")
    private Shift packagingShiftPlan;
    @Column(name = "packaging_done")
    private int packagingDone;
    @Column(name = "packaging_date_fact")
    private Date packagingDateFact;
    @Column(name = "packaging_shift_fact")
    private Shift packagingShiftFact;
    @Column(name = "storage_date")
    private Date storageDate;
    @Column(name = "storage_got")
    private int storageGot;
    @Column(name = "departure_date")
    private Date departureDate;
    @Column(name = "curr_quantity")
    private int currQuant;


    public int getStorageGot() {
        return storageGot;
    }

    public void setStorageGot(int storageGot) {
        this.storageGot = storageGot;
    }

    public int getCurrQuant() {
        return currQuant;
    }

    public void setCurrQuant(int currQuant) {
        this.currQuant = currQuant;
    }

    public Plan() {
        this.createDate = new Date();
    }

    public Shift getPackagingShiftPlan() {
        return packagingShiftPlan;
    }

    public void setPackagingShiftPlan(Shift packagingShiftPlan) {
        this.packagingShiftPlan = packagingShiftPlan;
    }

    public Shift getPackagingShiftFact() {
        return packagingShiftFact;
    }

    public void setPackagingShiftFact(Shift packagingShiftFact) {
        this.packagingShiftFact = packagingShiftFact;
    }

    public Plan(User planner, Order order) {
        this.planner = planner;
        this.order = order;
        this.createDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getPlanner() {
        return planner;
    }

    public void setPlanner(User planner) {
        this.planner = planner;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public int getLayers() {
        return layers;
    }

    public void setLayers(int layers) {
        this.layers = layers;
    }

    public Date getTaiwaneseDatePlan() {
        return taiwaneseDatePlan;
    }

    public void setTaiwaneseDatePlan(Date taiwaneseDatePlan) {
        this.taiwaneseDatePlan = taiwaneseDatePlan;
    }

    public Shift getTaiwaneseShiftPlan() {
        return taiwaneseShiftPlan;
    }

    public void setTaiwaneseShiftPlan(Shift taiwaneseShiftPlan) {
        this.taiwaneseShiftPlan = taiwaneseShiftPlan;
    }

    public Date getTaiwaneseDateFact() {
        return taiwaneseDateFact;
    }

    public void setTaiwaneseDateFact(Date taiwaneseDateFact) {
        this.taiwaneseDateFact = taiwaneseDateFact;
    }

    public Date getTaiwaneseShiftFact() {
        return taiwaneseShiftFact;
    }

    public void setTaiwaneseShiftFact(Date taiwaneseShiftFact) {
        this.taiwaneseShiftFact = taiwaneseShiftFact;
    }

    public Date getBobstDatePlan() {
        return bobstDatePlan;
    }

    public void setBobstDatePlan(Date bobstDatePlan) {
        this.bobstDatePlan = bobstDatePlan;
    }

    public Shift getBobstShiftPlan() {
        return bobstShiftPlan;
    }

    public void setBobstShiftPlan(Shift bobstShiftPlan) {
        this.bobstShiftPlan = bobstShiftPlan;
    }

    public Date getBobstDateFact() {
        return bobstDateFact;
    }

    public void setBobstDateFact(Date bobstDateFact) {
        this.bobstDateFact = bobstDateFact;
    }

    public Shift getBobstShiftFact() {
        return bobstShiftFact;
    }

    public void setBobstShiftFact(Shift bobstShiftFact) {
        this.bobstShiftFact = bobstShiftFact;
    }

    public Date getPackagingDatePlan() {
        return packagingDatePlan;
    }

    public void setPackagingDatePlan(Date packagingDatePlan) {
        this.packagingDatePlan = packagingDatePlan;
    }

    public Date getPackagingDateFact() {
        return packagingDateFact;
    }

    public void setPackagingDateFact(Date packagingDateFact) {
        this.packagingDateFact = packagingDateFact;
    }

    public Date getStorageDate() {
        return storageDate;
    }

    public void setStorageDate(Date storageDate) {
        this.storageDate = storageDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getTaiwanDone() {
        return taiwanDone;
    }

    public void setTaiwanDone(int taiwanDone) {
        this.taiwanDone = taiwanDone;
    }

    public int getBobstDone() {
        return bobstDone;
    }

    public void setBobstDone(int bobstDone) {
        this.bobstDone = bobstDone;
    }

    public int getPackagingDone() {
        return packagingDone;
    }

    public void setPackagingDone(int packagingDone) {
        this.packagingDone = packagingDone;
    }
}
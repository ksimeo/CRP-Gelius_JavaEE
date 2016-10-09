package com.ksimeo.yanu.entities.models;

/**
 * @author Ksimeo. Created on 10.09.2016 at 13:53 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public class PlansParcel {
    private int pageNumber;
    private Plan[] plans;
    private boolean isLast;
    public final static int PAGE_ROWS_NUMBER = 8;

    public PlansParcel() {
        plans = new Plan[PAGE_ROWS_NUMBER];
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Plan[] getPlans() {
        return plans;
    }

    public void setPlans(Plan[] plans) {
        this.plans = plans;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setIsLast(boolean isLast) {
        this.isLast = isLast;
    }
}

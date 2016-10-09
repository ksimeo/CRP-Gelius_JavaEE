package com.ksimeo.yanu.entities.models;

import java.util.List;

/**
 * @author Ksimeo. Created on 28.09.2016 at 18:46 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public class Parcel<E> {
    public final static int ROW_NUMBER_PAGE = 8;
    private int pageNumber;
    private List<E> items;
    private boolean isLastPage;

    public Parcel() {
    }

    public Parcel(int pageNumber, List<E> items) {
        this.pageNumber = pageNumber;
        this.items = items;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<E> getItems() {
        return items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }
}

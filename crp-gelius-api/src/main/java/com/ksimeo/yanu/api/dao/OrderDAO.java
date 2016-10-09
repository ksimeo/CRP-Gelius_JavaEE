package com.ksimeo.yanu.api.dao;

import com.ksimeo.yanu.entities.models.Order;

import java.util.List;

/**
 * @author Ksimeo. Created on 09.10.2016 at 16:25 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface OrderDAO {

    Order save(Order order);
    Order findOne(int id);
    List<Order> findAll();
    List<Order> findActual();
    List<Order> findNew();
    List<Order> findOld();
    List<Order> findSeveral(int from, int to);
}

package com.ksimeo.yanu.api.repository;

import com.ksimeo.yanu.entities.models.Order;

/**
 * @author Ksimeo. Created on 11.10.2016 at 15:20 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface OrderRepository {

    Order addOrder(Order order);
    Order getOrder(int id);
    void delOrder(int id);
}

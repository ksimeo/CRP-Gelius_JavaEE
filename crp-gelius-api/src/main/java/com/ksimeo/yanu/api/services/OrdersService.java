package com.ksimeo.yanu.api.services;

import com.ksimeo.yanu.entities.models.Order;
import com.ksimeo.yanu.entities.models.Parcel;

import java.util.List;

/**
 * @author Ksimeo. Created on 09.10.2016 at 16:30 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface OrdersService {
    Order addOrder(Order order);
    Order getOrder(int id);
    List<Order> getOrders();
    List<Order> getOldOrders();
    List<Order> getNewOrders();
    List<Order> getActualOrders();
    Parcel<Order> getOrderPage(int id);
}

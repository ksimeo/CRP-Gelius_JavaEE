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
    Order addOrder(Order order) throws Exception;
    Order getOrder(int id) throws Exception;
    List<Order> getOrders() throws Exception;
    List<Order> getOldOrders() throws Exception;
    List<Order> getNewOrders() throws Exception;
    List<Order> getActualOrders() throws Exception;
    Parcel<Order> getOrderPage(int id) throws Exception;
}
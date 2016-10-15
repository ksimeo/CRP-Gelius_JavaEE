package com.ksimeo.yanu.impl.dao;

import com.ksimeo.yanu.api.repository.dao.OrderDAO;
import com.ksimeo.yanu.entities.models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo. Created on 09.10.2016 at 16:26 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public class OrderDaoMock implements OrderDAO {
    List<Order> orders;

    public OrderDaoMock() {
        orders = new ArrayList<>();
    }

    public Order save(Order order) {
        orders.add(order);
        order.setId(orders.indexOf(order) + 1);
        return order;
    }

    public Order findOne(int id) {
        for (Order order : orders)
            if (order.getId() == id) return order;
        return null;
    }

    public List<Order> findAll() {
        return orders;
    }

    public List<Order> findActual() {
        List<Order> res = new ArrayList<>();
        for (Order order : orders) {
            if (order.isActual()) res.add(order);
        }
        return res;
    }

    public List<Order> findNew() {
        List<Order> res = new ArrayList<>();
        for (Order order : orders) {
            if (order.getPlan() == null) res.add(order);
        }
        return res;
    }

    public List<Order> findOld() {
        List<Order> res = new ArrayList<>();
        for (Order order : orders) {
            if (order.isActual() == false) res.add(order);
        }
        return res;
    }

    public List<Order> findSeveral(int from, int to) {
        return  null;
    }
}

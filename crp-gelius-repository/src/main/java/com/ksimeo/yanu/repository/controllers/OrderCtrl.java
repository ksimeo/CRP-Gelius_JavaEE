package com.ksimeo.yanu.repository.controllers;

import com.ksimeo.yanu.entities.models.Order;
import com.ksimeo.yanu.repository.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Ksimeo. Created on 15.10.2016 at 13:50 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class OrderCtrl {
    @Autowired
    private OrderDAO ordrDao;


    @RequestMapping(value = "/addordr", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Order addOrder(Order ordr) {
        return ordrDao.save(ordr);
    }

    @RequestMapping(value = "/getordr", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Order getOrder(@PathVariable int id) {
        return ordrDao.findOne(id);
    }

    @RequestMapping(value = "/getallordrs", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Order> getAllOrders() {
        return (List<Order>)ordrDao.findAll();
    }
}

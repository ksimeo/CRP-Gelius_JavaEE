package com.ksimeo.yanu.repository.controllers;


import com.ksimeo.yanu.entities.models.Plan;
import com.ksimeo.yanu.repository.dao.PlanDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Ksimeo. Created on 15.10.2016 at 16:40 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class PlanCtrl {
    @Autowired
    private PlanDAO planDao;

    @RequestMapping(value = "/addpln", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Plan addPlan(Plan plan) {
        return planDao.save(plan);
    }

    @RequestMapping(value = "/getpln/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Plan getPlanById(@PathVariable int id) {
        return planDao.findOne(id);
    }

    @RequestMapping(value = "/getplns", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Plan> getAllPlans() {
        return (List<Plan>) planDao.findAll();
    }

    @RequestMapping(value = "/delpln/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public void deletePlanById(@PathVariable int id) {
        planDao.delete(id);
    }
}
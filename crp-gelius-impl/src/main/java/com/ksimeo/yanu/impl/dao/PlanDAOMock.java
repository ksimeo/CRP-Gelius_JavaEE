package com.ksimeo.yanu.impl.dao;

import com.ksimeo.yanu.entities.models.Plan;
import com.ksimeo.yanu.api.repository.dao.PlanDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo. Created on 27.07.2016 at 18:10 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public class PlanDAOMock implements PlanDAO {

    private List<Plan> plans;

    public PlanDAOMock() {
        plans = new ArrayList<>();
//        plans.add(new Plan());
    }

    @Override
    public Plan save(Plan plan) {
        plans.add(plan);
        plan.setId(plans.indexOf(plan));
        return plan;
    }

    public Plan findOne(int id) {
        for (Plan plan : plans)
        if (plan.getId() == id) return plan;
        return null;
    }

    @Override
    public List<Plan> findAll() {
        return plans;
    }

    @Override
    public List<Plan> findActual() {
        List<Plan> res = new ArrayList<>();
        for (Plan plan : plans) {
            if (plan.getDepartureDate() == null) res.add(plan);
        }
        return res;
    }

    @Override
    public List<Plan> findOld() {
        List<Plan> res = new ArrayList<>();
        for (Plan plan : plans) {
            if (plan.getDepartureDate() != null) res.add(plan);
        }
        return res;
    }

    @Override
    public List<Plan> findActualForTaiwanese() {
        List<Plan> res = new ArrayList<>();
        for (Plan plan : plans) {
            if (plan.getTaiwaneseDateFact() == null) res.add(plan);
        }
        return res;
    }

    @Override
    public List<Plan> findActualForBost() {
        List<Plan> res = new ArrayList<>();
        for (Plan plan : plans) {
            if (plan.getTaiwaneseDateFact() != null && plan.getBobstDateFact() == null) res.add(plan);
        }
        return res;
    }

    @Override
    public List<Plan> findActualForPackaging() {
        List<Plan> res = new ArrayList<>();
        for (Plan plan : plans) {
            if (plan.getBobstDateFact() != null && plan.getPackagingDateFact() == null) res.add(plan);
        }
        return res;
    }

    @Override
    public List<Plan> findActualForStorage() {
        List<Plan> res = new ArrayList<>();
        for (Plan plan : plans) {
            if (plan.getPackagingDateFact() != null && plan.getDepartureDate() == null) res.add(plan);
        }
        return res;
    }

    @Override
    public void drop(int id) {
        plans.remove(id);
    }

    @Override
    public void dropAll() {
        plans.clear();
    }

    public List<Plan> findSeveral(int from, int to) {
        List<Plan> res = new ArrayList<>(to - from);
        int id = 1;
        for (Plan plan : plans) {
            if (id >= from) {
                res.add(plan);
                if (id == to || id == res.size()) return res;
            }
            id++;
        }
        return null;
    }
}

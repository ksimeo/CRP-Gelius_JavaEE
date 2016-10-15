package com.ksimeo.yanu.impl.services;

import com.ksimeo.yanu.entities.models.Plan;
import com.ksimeo.yanu.entities.models.PlansParcel;
import com.ksimeo.yanu.api.repository.dao.PlanDAO;
import com.ksimeo.yanu.api.services.PlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ksimeo. Created on 27.07.2016 at 18:01 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class PlanServiceImpl implements PlansService {
    @Autowired
    private PlanDAO planDAO;

    @Override
    public Plan addPlan(Plan plan) {
        return planDAO.save(plan);
    }

    @Override
    public Plan getPlan(int id) {
        return planDAO.findOne(id);
    }

    @Override
    public List<Plan> getPlans() {
        return planDAO.findAll();
    }

    @Override
    public List<Plan> getPlansForTaiwanese() {
        return planDAO.findActualForTaiwanese();
    }

    @Override
    public List<Plan> getPlansForBobst() {
        return planDAO.findActualForBost();
    }

    @Override
    public List<Plan> getPlansForPackaging() {
        return planDAO.findActualForPackaging();
    }

    @Override
    public List<Plan> getPlansForStorage() {
        return planDAO.findActualForStorage();
    }

    @Override
    public List<Plan> getActualPlans() {
        return planDAO.findActual();
    }

    @Override
    public List<Plan> getOldPlans() {
        return null;
    }

    @Override
    public PlansParcel getPage(int page) {
        int rowsNumber = PlansParcel.PAGE_ROWS_NUMBER;
        PlansParcel res = new PlansParcel();
        int to = rowsNumber * page - 1;
        int from = to - rowsNumber;
        Plan[] planset = new Plan [8];
        planDAO.findSeveral(from, to).toArray(planset);
        res.setPlans(planset);
        res.setPageNumber(page);
        List<Plan> nextPage = planDAO.findSeveral(from + rowsNumber, to + rowsNumber);
        if (nextPage == null || nextPage.size() == 0) res.setIsLast(true);
        return res;
    }
}

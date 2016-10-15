package com.ksimeo.yanu.api.repository;

import com.ksimeo.yanu.entities.models.Plan;

/**
 * @author Ksimeo. Created on 11.10.2016 at 15:19 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface PlanRepository {
    Plan addPlan(Plan plan);
    Plan getPlan(int id);
    void delPlan(int id);
}

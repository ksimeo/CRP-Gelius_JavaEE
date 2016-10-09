package com.ksimeo.yanu.api.services;

import com.ksimeo.yanu.entities.models.Plan;
import com.ksimeo.yanu.entities.models.PlansParcel;

import java.util.List;

/**
 * @author Ksimeo. Created on 27.07.2016 at 17:55 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface PlansService {

    Plan addPlan(Plan plan);
    Plan getPlan(int id);
    List<Plan> getPlans();
    List<Plan> getActualPlans();
    List<Plan> getPlansForTaiwanese();
    List<Plan> getPlansForBobst();
    List<Plan> getPlansForPackaging();
    List<Plan> getPlansForStorage();
    List<Plan> getOldPlans();
    PlansParcel getPage(int page);
}

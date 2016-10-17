package com.ksimeo.yanu.api.services;

import com.ksimeo.yanu.entities.models.Parcel;
import com.ksimeo.yanu.entities.models.Plan;

import java.util.List;

/**
 * @author Ksimeo. Created on 27.07.2016 at 17:55 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface PlansService {

    Plan addPlan(Plan plan) throws Exception;
    Plan getPlan(int id) throws Exception;
    List<Plan> getPlans() throws Exception;
    List<Plan> getActualPlans() throws Exception;
    List<Plan> getPlansForTaiwanese() throws Exception;
    List<Plan> getPlansForBobst() throws Exception;
    List<Plan> getPlansForPackaging() throws Exception;
    List<Plan> getPlansForStorage() throws Exception;
    List<Plan> getOldPlans() throws Exception;
    Parcel<Plan> getPage(int page) throws Exception;
}
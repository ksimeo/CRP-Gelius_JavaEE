package com.ksimeo.yanu.api.dao;

import com.ksimeo.yanu.entities.models.Plan;

import java.util.List;

/**
 * @author Ksimeo. Created on 27.07.2016 at 18:02 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface PlanDAO {

    Plan save(Plan plan);
    Plan findOne(int id);
    List<Plan> findAll();
    List<Plan> findActual();
    List<Plan> findActualForTaiwanese();
    List<Plan> findActualForBost();
    List<Plan> findActualForPackaging();
    List<Plan> findActualForStorage();
    List<Plan> findOld();
    List<Plan> findSeveral(int from, int to);
    void drop(int id);
    void dropAll();
}

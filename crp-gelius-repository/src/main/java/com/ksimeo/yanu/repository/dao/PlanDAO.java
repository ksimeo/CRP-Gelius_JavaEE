package com.ksimeo.yanu.repository.dao;

import com.ksimeo.yanu.entities.models.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ksimeo. Created on 15.10.2016 at 16:33 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface PlanDAO extends CrudRepository<Plan, Integer> {
}

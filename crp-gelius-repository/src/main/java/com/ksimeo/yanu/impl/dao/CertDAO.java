package com.ksimeo.yanu.impl.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ksimeo.yanu.entities.models.Cert;

/**
 * @author Ksimeo. Created on 15.10.2016 at 14:24 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface CertDAO extends CrudRepository<Cert, Integer> {
}
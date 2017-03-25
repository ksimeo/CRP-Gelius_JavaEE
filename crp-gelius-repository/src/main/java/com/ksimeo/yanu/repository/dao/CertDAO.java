package com.ksimeo.yanu.repository.dao;

import com.ksimeo.yanu.entities.models.Cert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 *
 * @author Ksimeo. Created on 19.07.2016 at 13:38 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface CertDAO extends CrudRepository<Cert, Integer> {
}
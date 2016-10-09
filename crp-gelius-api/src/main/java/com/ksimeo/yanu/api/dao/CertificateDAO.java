package com.ksimeo.yanu.api.dao;

import com.ksimeo.yanu.entities.models.Сert;
import java.util.List;

/**
 *
 *
 *
 * @author Ksimeo. Created on 19.07.2016 at 13:38 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface CertificateDAO {

    Сert save(Сert certificate);
    Сert findOne(int id);
    List<Сert> findAll();
}
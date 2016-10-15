package com.ksimeo.yanu.api.repository.dao;

import com.ksimeo.yanu.entities.models.Cert;
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

    Cert save(Cert certificate);
    Cert findOne(int id);
    List<Cert> findAll();
}
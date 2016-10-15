package com.ksimeo.yanu.api.repository;

import com.ksimeo.yanu.entities.models.Cert;

/**
 * @author Ksimeo. Created on 11.10.2016 at 15:18 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface CertifcateRepository {

    Cert addCertificate(Cert cert);
    Cert getCertificate(int id);
    void delCertificate(int id);
}

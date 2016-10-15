package com.ksimeo.yanu.api.services;

import com.ksimeo.yanu.entities.models.Cert;

import java.util.List;

/**
 * @author Ksimeo. Created on 19.07.2016 at 12:31 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface CertificatesService {

    Cert addCertificate(Cert certificate);
    Cert getCertificate(int id);
    List<Cert> getCertificates();
    void deleteCertificate(int id);
}

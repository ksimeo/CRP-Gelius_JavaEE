package com.ksimeo.yanu.repository.controllers;

import com.ksimeo.yanu.entities.models.Cert;
import com.ksimeo.yanu.repository.dao.CertDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Ksimeo. Created on 15.10.2016 at 15:51 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class CertCtrl {
    @Autowired
    private CertDAO certDao;

    @RequestMapping(value = "/addcrt", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public Cert addCert(Cert cert) {
        return certDao.save(cert);
    }

    @RequestMapping(value = "/getcrts", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Cert> getAllCerts() {
        return (List<Cert>)certDao.findAll();
    }

    @RequestMapping(value = "/getcrt/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Cert getCertById(@PathVariable int id) {
        return certDao.findOne(id);
    }

    @RequestMapping(value = "/delcert/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void delCertById(@PathVariable int id) {
        certDao.delete(id);
    }
}

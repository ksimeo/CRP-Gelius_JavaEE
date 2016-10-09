package com.ksimeo.yanu.impl.dao;

import com.ksimeo.yanu.entities.models.User;
import com.ksimeo.yanu.entities.models.Сert;
import com.ksimeo.yanu.api.dao.CertificateDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo. Created on 19.07.2016 at 14:19 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public class CertificateDAOMock implements CertificateDAO {

    private List<Сert> certificates;

    public CertificateDAOMock() {
        certificates = new ArrayList<>();
        certificates.add(new Сert(1, "Технический паспорт на ящики типа А",
                new User("manager", "manager123", "Алексей", "Осипов", "alex.osip@gmail.com", 1),
                "D:\\upload_docs\\1240249560CRP_Gelius_en_ru.pdf"));
        certificates.add(new Сert(2, "Технический паспорт на ящики типа Б",
                new User("evgeniy", "evg123", "Евгений", "Ильин", "ilyin@hotmail.com", 1),
                "D:\\upload_docs\\153099529901. Реестр продукции (сокращенный).png"));
    }

    public Сert save(Сert certificate) {
        certificates.add(certificate);
        certificate.setId(certificates.indexOf(certificate) + 1);
        return certificate;
    }

    public Сert findOne(int id) {
        return certificates.get(id - 1);
    }

    public List<Сert> findAll() {
        return certificates;
    }

}
package com.ksimeo.yanu.impl.services;

import com.ksimeo.yanu.repository.dao.CertificateDAO;
import com.ksimeo.yanu.api.services.CertificatesService;
import com.ksimeo.yanu.entities.models.Cert;
import com.ksimeo.yanu.impl.config.RepositoryServerConfig;
import com.ksimeo.yanu.impl.dao.CertificateDAOMock;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ksimeo.yanu.impl.helpers.RestHelper.sendGet;
import static com.ksimeo.yanu.impl.helpers.RestHelper.sendPost;

/**
 * @author Ksimeo. Created on 19.07.2016 at 13:36 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class CertificateServImpl implements CertificatesService {

    private static final String REPOSITORY_SERVER_URL = RepositoryServerConfig.URL;

    private String fullURL;
    private String echoData;

    private ObjectMapper om;

    private CertificateDAO certDao = new CertificateDAOMock();

    public CertificateServImpl() {
        om = new ObjectMapper();
    }

    public Cert addCertificate(Cert certificate) throws Exception {
        fullURL = REPOSITORY_SERVER_URL + "/addcert";
        String dataToSend = om.writeValueAsString(certificate);
        echoData = sendPost(fullURL, dataToSend);
        return om.readValue(echoData, new TypeReference<Cert>() {});

    }

    public Cert getCertificate(int id) throws Exception {
        fullURL = REPOSITORY_SERVER_URL + "/getcrt/" + id;
        echoData = sendGet(fullURL);
        return om.readValue(echoData, new TypeReference<Cert>() { });
    }

    public List<Cert> getCertificates() throws Exception {
        fullURL = REPOSITORY_SERVER_URL + "/getcerts";
        echoData = sendGet(fullURL);
        return om.readValue(echoData, new TypeReference<Cert>() {});
    }

    public void deleteCertificate(int id) throws Exception {
        fullURL = REPOSITORY_SERVER_URL + "/delcert/" + id;
        echoData = sendGet(fullURL);
    }
}

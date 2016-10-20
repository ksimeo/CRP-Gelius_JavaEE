package com.ksimeo.yanu.repository.controllers;

import com.ksimeo.yanu.entities.models.Cert;
import com.ksimeo.yanu.repository.dao.CertDAO;
import junit.framework.TestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Ksimeo. Created on 15.10.2016 at 17:09 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:./crp-gelius-repository/src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
@WebAppConfiguration
public class CertCtrlTest extends TestCase {
    @InjectMocks
    private CertCtrl certCtrl;
    @Autowired
    private CertDAO certDao;

    private ObjectMapper mapper;

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mapper = new ObjectMapper();
        Cert testCertificate1 = new Cert("Certificate 1");
        Cert testCertificate2 = new Cert("Certificate 2");
        certDao.save(testCertificate1);
        certDao.save(testCertificate2);
    }

    @Test
    public void addCert() throws Exception {
        Cert cert = new Cert("Certificate 2");
        String dataToSend = mapper.writeValueAsString(cert);
        MvcResult res = mockMvc.perform(post("/addcert").content(dataToSend).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String echoData = res.getResponse().getContentAsString();
        Cert reqCert = mapper.readValue(echoData, new TypeReference<Cert>(){});
        assertNotNull(reqCert);
        assertEquals(reqCert.getId(), 2);
    }

    @Test
    public void getCertById() throws Exception {
        MvcResult res = mockMvc.perform(get("/getcrt/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String echoData = res.getResponse().getContentAsString();
        Cert cert = mapper.readValue(echoData, new TypeReference<Cert>(){});
        assertNotNull(cert);
        assertEquals(cert.getId(), 1);
    }

    @Test
    public void getAllCerts() throws Exception {
        MvcResult res = mockMvc.perform(get("/getcrts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String echoData = res.getResponse().getContentAsString();
        List<Cert> certs = mapper.readValue(echoData, new TypeReference<List<Cert>>(){ });
        assertNotNull(certs);
        assertEquals(certs.size(), 3);
    }

    @After
    public void tearDown() throws Exception {
        certDao.deleteAll();
    }
}


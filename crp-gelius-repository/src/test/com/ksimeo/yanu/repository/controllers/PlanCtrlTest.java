package com.ksimeo.yanu.repository.controllers;

import com.ksimeo.yanu.entities.models.Plan;
import com.ksimeo.yanu.repository.dao.PlanDAO;
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
public class PlanCtrlTest extends TestCase {
    @InjectMocks
    private PlanCtrl planCtrl;

    private MockMvc mockMvc;
    @Autowired
    private PlanDAO planDao;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private ObjectMapper mapper;

    private Plan createdPlan;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mapper = new ObjectMapper();
        Plan testPlan1 = new Plan(null, null);
        Plan testPlan2 = new Plan(null, null);
        planDao.save(testPlan1);
        planDao.save(testPlan2);
    }

    @Test
    public void addPlan() throws Exception {
        Plan testPlan = new Plan(null, null);
        String dataToSend = mapper.writeValueAsString(testPlan);
        MvcResult res = mockMvc.perform(post("/addpln").content(dataToSend).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String echoData = res.getResponse().getContentAsString();
        Plan plan = mapper.readValue(echoData, new TypeReference<Plan>(){});
        assertNotNull(plan);
    }

    @Test
    public void getPlanById() throws Exception {
        MvcResult res = mockMvc.perform(get("/getpln/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String echoData = res.getResponse().getContentAsString();
        Plan plan = mapper.readValue(echoData, new TypeReference<Plan>(){});
        assertNotNull(plan);
        assertEquals(plan.getId(), 1);
    }

    @Test
    public void getAllPlans() throws Exception {
        MvcResult res = mockMvc.perform(get("/getplns"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String echoData = res.getResponse().getContentAsString();
        List<Plan> plans = mapper.readValue(echoData, new TypeReference<List<Plan>>(){});
        assertNotNull(plans);
        assertEquals(plans.size(), 3);
    }

    @After
    public void tearDown() throws Exception {
        planDao.deleteAll();
    }
}
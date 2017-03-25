package com.ksimeo.yanu.repository.controllers;

import com.ksimeo.yanu.entities.models.User;
import com.ksimeo.yanu.repository.dao.UserDAO;
import junit.framework.TestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.After;
import org.junit.BeforeClass;
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
public class UserCtrlTest extends TestCase {
    @InjectMocks
    private UserCtrl userCtrl;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private User createUser;

    private ObjectMapper mapper;


    @Autowired
    private UserDAO userDao;

    @BeforeClass
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mapper = new ObjectMapper();
        User testUser1 = new User("TestUser1", "test123", 1);
        User testUser2 = new User("TestUser2", "test123", 2);
        userDao.save(testUser1);
        userDao.save(testUser2);
    }

    @Test
    public void addUser() throws Exception {
        User testUser = new User("TestUser", "test123", 0);
        String toSend = mapper.writeValueAsString(testUser);
        MvcResult res = mockMvc.perform(post("/addusr").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String data = res.getResponse().getContentAsString();
        User createsUser = mapper.readValue(data, new TypeReference<User>(){});
        assertNotNull(createsUser);
    }

    @Test
    public void getUserById() throws Exception {
        MvcResult res = mockMvc.perform(get("/getusr/2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String data = res.getResponse().getContentAsString();
        User user = mapper.readValue(data, new TypeReference<User>(){ });
        assertNotNull(user);
    }

    @Test
    public void getAllUsers() throws Exception {
        MvcResult res = mockMvc.perform(get("/usrs").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String data = res.getResponse().getContentAsString();
        List<User> users = mapper.readValue(data, new TypeReference<List<User>>() {} );
        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertTrue(users.size()==3);
    }

    @After
    public void tearDown() throws Exception {
        userDao.deleteAll();
    }
}

package com.ksimeo.yanu.impl.controllers;

import com.ksimeo.yanu.entities.models.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

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

    private WebApplicationContext webApplicationContext;

    private User createUser;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addUser() throws Exception {

    }

    @Test
    public void getUserById() throws Exception {

    }

    @Test
    public void getAllUsers() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
}

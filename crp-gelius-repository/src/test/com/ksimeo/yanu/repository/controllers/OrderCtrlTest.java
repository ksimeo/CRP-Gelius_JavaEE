package com.ksimeo.yanu.repository.controllers;

import com.ksimeo.yanu.entities.models.Order;
import com.ksimeo.yanu.repository.dao.OrderDAO;
import junit.framework.TestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.AfterClass;
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
public class OrderCtrlTest extends TestCase {
    @InjectMocks
    private OrderCtrl orderCtrl;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private OrderDAO orderDao;

    private Order createdOrder;
    private Order order1;
    private Order order2;

    private String toSend;

    private ObjectMapper mapper;

    @BeforeClass
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mapper = new ObjectMapper();
        Order order1 = new Order(null, 1, null);
        Order order2 = new Order(null, 2, null);
        orderDao.save(order1);
        orderDao.save(order2);
    }

    @Test
    public void addOrder() throws Exception {
        Order testOrder = new Order(null, 3, null);
        toSend = mapper.writeValueAsString(testOrder);
        MvcResult res = mockMvc.perform(post("/addordr").content(toSend).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    public void getOrderById() throws Exception {
        MvcResult res = mockMvc.perform(get("/getordr/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String echoData = res.getResponse().getContentAsString();
        Order order = mapper.readValue(echoData, new TypeReference<Order>() { });
        assertNotNull(order);
        assertEquals(order.getId(), 1);
    }

    @Test
    public void getAllOrders() throws Exception {
        MvcResult res = mockMvc.perform(get("/getallordrs"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String echoData = res.getResponse().getContentAsString();
        List<Order> orders = mapper.readValue(echoData, new TypeReference<List<Order>>() {});
        assertNotNull(orders);
        assertEquals(orders.size(), 3);
    }

    @AfterClass
    public void tearDown() throws Exception {
        orderDao.deleteAll();
    }
}
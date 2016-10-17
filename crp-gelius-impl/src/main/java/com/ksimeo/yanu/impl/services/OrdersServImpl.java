package com.ksimeo.yanu.impl.services;

import com.ksimeo.yanu.api.repository.dao.OrderDAO;
import com.ksimeo.yanu.api.services.OrdersService;
import com.ksimeo.yanu.entities.models.Order;
import com.ksimeo.yanu.entities.models.Parcel;
import com.ksimeo.yanu.impl.config.RepositoryServerConfig;
import com.ksimeo.yanu.impl.dao.OrderDaoMock;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ksimeo.yanu.impl.helpers.RestHelper.sendGet;
import static com.ksimeo.yanu.impl.helpers.RestHelper.sendPost;

/**
 * @author Ksimeo. Created on 09.10.2016 at 16:31 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class OrdersServImpl implements OrdersService {

    private static final String REPOSITORY_SERVER_URL = RepositoryServerConfig.URL;

    private String fullURL;
    private String echoData;
    private String dataToSend;

    private ObjectMapper om;

    private OrderDAO orderDAO = new OrderDaoMock();

    public OrdersServImpl() {
        om = new ObjectMapper();
    }

    public Order addOrder(Order order) throws Exception {
        fullURL = REPOSITORY_SERVER_URL + "/addordr";
        dataToSend = om.writeValueAsString(order);
        echoData = sendPost(fullURL, dataToSend);
        return om.readValue(echoData, new TypeReference<Order>() {
        });
    }

    public Order getOrder(int id) throws Exception {
        fullURL = REPOSITORY_SERVER_URL + "/getorder/" + id;
        echoData = sendGet(fullURL);
        return om.readValue(echoData, new TypeReference<Order>() {
        });
    }

    public List<Order> getOrders() throws Exception {
        fullURL = REPOSITORY_SERVER_URL + "/getordrs";
        echoData = sendGet(fullURL);
        return om.readValue(echoData, new TypeReference<Order>() { });
    }

    public List<Order> getActualOrders() {
        return orderDAO.findActual();
    }

    public List<Order> getOldOrders() {
        return orderDAO.findOld();
    }

    public List<Order> getNewOrders() {
        return orderDAO.findNew();
    }

    @Override
    public Parcel<Order> getOrderPage(int page) {
        Map<String, Integer> calcRes = calcPage(page);
        int from = calcRes.get("from");
        int to = calcRes.get("to");
        List<Order> orders = orderDAO.findSeveral(from, to);
        if (orders != null) {
            Parcel<Order> toSend = new Parcel<>(page, orders);
            if (orders.size() == Parcel.ROW_NUMBER_PAGE) {
                calcRes = calcPage(page + 1);
                from = calcRes.get("from");
                to = calcRes.get("to");
                List<Order> nextOrders = orderDAO.findSeveral(from, to);
                if (nextOrders != null && nextOrders.size() != 0) {
                    toSend.setIsLastPage(true);
                }
                return toSend;
            } else {
                toSend.setIsLastPage(true);
            }
        }
        return null;
    }

    private Map<String, Integer> calcPage(int page) {
        int to = page* Parcel.ROW_NUMBER_PAGE - 1;
        int from = to - Parcel.ROW_NUMBER_PAGE;
        Map<String, Integer> res = new HashMap<>(2);
        res.put("from", from);
        res.put("to", to);
        return res;
    }
}
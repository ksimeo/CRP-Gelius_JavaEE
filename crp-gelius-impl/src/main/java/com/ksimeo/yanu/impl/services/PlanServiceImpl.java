package com.ksimeo.yanu.impl.services;

import com.ksimeo.yanu.repository.dao.PlanDAO;
import com.ksimeo.yanu.api.services.PlansService;
import com.ksimeo.yanu.entities.models.Parcel;
import com.ksimeo.yanu.entities.models.Plan;
import com.ksimeo.yanu.entities.models.PlansParcel;
import com.ksimeo.yanu.entities.models.User;
import com.ksimeo.yanu.impl.config.RepositoryServerConfig;
import com.ksimeo.yanu.impl.dao.PlanDAOMock;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ksimeo.yanu.impl.helpers.RestHelper.sendGet;
import static com.ksimeo.yanu.impl.helpers.RestHelper.sendPost;

/**
 * @author Ksimeo. Created on 27.07.2016 at 18:01 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class PlanServiceImpl implements PlansService {

    private static final String REPOSITORY_SERVER_URL = RepositoryServerConfig.URL;

    private String fullURL;
    private String echoData;
    private String dataToSend;
    private PlanDAO planDAO = new PlanDAOMock();

    private ObjectMapper om;

    public PlanServiceImpl() {
        om = new ObjectMapper();
    }

    @Override
    public Plan addPlan(Plan plan) throws Exception {
        fullURL = REPOSITORY_SERVER_URL + "/addpln";
        dataToSend = om.writeValueAsString(plan);
        echoData = sendPost(fullURL, dataToSend);
        return om.readValue(echoData, new TypeReference<User>() { });
    }

    @Override
    public Plan getPlan(int id) throws Exception {
        fullURL = REPOSITORY_SERVER_URL + "/getpln/" + id;
        echoData = sendGet(fullURL);
        return om.readValue(echoData, new TypeReference<Plan>() { });
    }

    @Override
    public List<Plan> getPlans() throws Exception{
        fullURL = REPOSITORY_SERVER_URL + "/getplns";
        echoData = sendGet(fullURL);
        return om.readValue(echoData, new TypeReference<List<User>>() { });
    }

    @Override
    public List<Plan> getPlansForTaiwanese() {
        return planDAO.findActualForTaiwanese();
    }

    @Override
    public List<Plan> getPlansForBobst() {
        return planDAO.findActualForBost();
    }

    @Override
    public List<Plan> getPlansForPackaging() {
        return planDAO.findActualForPackaging();
    }

    @Override
    public List<Plan> getPlansForStorage() {
        return planDAO.findActualForStorage();
    }

    @Override
    public List<Plan> getActualPlans() {
        return planDAO.findActual();
    }

    @Override
    public List<Plan> getOldPlans() {
        return null;
    }

    @Override
    public Parcel<Plan> getPage(int page) throws Exception {
        Map<String, Integer> pointNumb = calcPage(page);
        int from = pointNumb.get("from");
        int to = pointNumb.get("to");
        fullURL = REPOSITORY_SERVER_URL + "getplnpage/from/" + from + "/to/" + to;
        echoData = sendGet(fullURL);
        List<Plan> plans = om.readValue(echoData, new TypeReference<List<Plan>>() { });
        Parcel<Plan> toSend = new Parcel<>();
        toSend.setItems(plans);
        toSend.setPageNumber(page);
        if (plans.size() < Parcel.ROW_NUMBER_PAGE) {
          toSend.setIsLastPage(true);
        } else {
            pointNumb = calcPage(page + 1);
            from = pointNumb.get("from");
            to = pointNumb.get("to");
            fullURL = REPOSITORY_SERVER_URL + "getplnpage/from/" + from + "/to/" + to;
            echoData = sendGet(fullURL);
            List<Plan> plansNext = om.readValue(echoData, new TypeReference<List<Plan>>() { });
            if (plansNext == null) toSend.setIsLastPage(true);
        }
        return toSend;
    }

    private Map<String, Integer> calcPage(int page) {
        int rowsNumber = PlansParcel.PAGE_ROWS_NUMBER;
        PlansParcel res = new PlansParcel();
        int to = rowsNumber * page - 1;
        int from = to - rowsNumber;
        Map<String, Integer> toSend = new HashMap<>();
        toSend.put("from", from);
        toSend.put("to", to);
        return toSend;
    }
}

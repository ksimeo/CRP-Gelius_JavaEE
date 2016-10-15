package com.ksimeo.yanu.impl.services;

import com.ksimeo.yanu.api.services.UsersService;
import com.ksimeo.yanu.entities.gto.UserGTO;
import com.ksimeo.yanu.entities.models.User;
import com.ksimeo.yanu.impl.config.RepositoryConfig;
import com.ksimeo.yanu.impl.helpers.EncoderHelper;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ksimeo.yanu.impl.helpers.RestHelper.sendGet;
import static com.ksimeo.yanu.impl.helpers.RestHelper.sendPost;

/**
 * @author Ksimeo. Created on 09.10.2016 at 15:19 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class UsersServImpl implements UsersService {

    private static final String REPOSITORY_URL = RepositoryConfig.URL;

    private String fullURL;
    private String echoData;
    private String dataToSend;

    private ObjectMapper om = new ObjectMapper();


    public User addUser(User usr) throws Exception {
        fullURL = REPOSITORY_URL + "/addusr";
        dataToSend = om.writeValueAsString(usr);
        echoData = sendPost(fullURL, dataToSend);
        return (User) om.readValue(echoData, new TypeReference<User>(){});
    }

    public User getUser(String login, String password) throws Exception {
        fullURL = REPOSITORY_URL + "/getusrbyloginpassw";
        password = EncoderHelper.String2Hash(password);
        dataToSend = om.writeValueAsString(new UserGTO(login, password));
        echoData = sendPost(fullURL, dataToSend);
        return (User) om.readValue(echoData, new TypeReference<User>() { });
    }

    public List<User> getUsers() throws Exception {
        fullURL = REPOSITORY_URL + "/getallusrs";
        echoData = sendGet(fullURL);
        return om.readValue(echoData, new TypeReference<List<User>>() {
        });
    }

    public List<User> getUsers(int role) {
        return null;
    }

    public void delUser(int id) throws Exception{
        fullURL = REPOSITORY_URL + "/delusr/" + id;
        sendGet(fullURL);
    }
}

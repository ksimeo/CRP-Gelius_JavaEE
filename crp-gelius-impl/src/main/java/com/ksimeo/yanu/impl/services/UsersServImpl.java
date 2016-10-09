package com.ksimeo.yanu.impl.services;

import com.ksimeo.yanu.api.dao.UserDAO;
import com.ksimeo.yanu.api.services.UsersService;
import com.ksimeo.yanu.entities.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ksimeo. Created on 09.10.2016 at 15:19 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class UsersServImpl implements UsersService {
    @Autowired
    private UserDAO usrDao;
//    = new UserDaoMocks();

    public User addUser(User usr) {
        return null;
    }

    public User getUser(String login, String password) {
        return usrDao.findOne(login, password);
    }

    public List<User> getUsers() {
        return null;
    }

    public List<User> getUsers(int role) {
        return null;
    }
}

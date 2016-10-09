package com.ksimeo.yanu.admin.services.impl;

import com.ksimeo.yanu.admin.dao.UserDao;
import com.ksimeo.yanu.admin.dao.mock.UserDaoMock;
import com.ksimeo.yanu.admin.gto.UserGTO;
import com.ksimeo.yanu.admin.models.User;
import com.ksimeo.yanu.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Ksimeo. Created on 02.10.2016 at 20:29 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserServImpl implements UserService {
    @Autowired
    private UserDao usrDao = new UserDaoMock();

    public User getUser(UserGTO usrInfo) {
        return usrDao.findOne(usrInfo.getLogin(), usrInfo.getPassword());
    }

    public void createUser(UserGTO usrInfo) throws SQLException {
        User user = usrDao.save(new User(usrInfo.getLogin(), usrInfo.getPassword(), usrInfo.getName(), usrInfo.getSurname(),
                usrInfo.getRole()));
        if (user == null) throw new SQLException();
    }

    public List<User> getAll() {
        return usrDao.findAll();
    }
}

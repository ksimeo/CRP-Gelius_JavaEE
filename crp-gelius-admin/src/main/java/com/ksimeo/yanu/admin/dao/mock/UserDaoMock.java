package com.ksimeo.yanu.admin.dao.mock;

import com.ksimeo.yanu.admin.dao.UserDao;
import com.ksimeo.yanu.admin.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo. Created on 02.10.2016 at 20:34 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public class UserDaoMock implements UserDao {
    private List<User> users;
    private static int count = 1;

    public UserDaoMock() {
        users = new ArrayList<>();
        users.add(new User(0, "admin", "admin123", 0));
    }

    @Override
    public User findOne(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(login)) {
                if (user.getPassword().equals(password)) return user;
                else return null;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return users;
    }

    @Override
    public User save(User usr) {
        usr.setId(count++);
        users.add(usr);
        return usr;
    }
}

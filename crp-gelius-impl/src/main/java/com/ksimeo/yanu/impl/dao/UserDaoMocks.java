package com.ksimeo.yanu.impl.dao;

import com.ksimeo.yanu.api.dao.UserDAO;
import com.ksimeo.yanu.entities.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo. Created on 09.10.2016 at 15:34 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public class UserDaoMocks implements UserDAO {
    private List<User> usrs;

    public UserDaoMocks() {
        usrs = new ArrayList<User>();
        usrs.add(new User("admin", "admin123", "Александр", "Карбачин", "sobakabarabaka@gmail.com", 0));
        usrs.add(new User("manager", "manager123", "Алексей", "Осипов", "osip@gmail.com", 1));
        usrs.add(new User("planner", "planner123", "Михаил", "Иванов", "mih_ivanov@gmail.com", 2));
        usrs.add(new User("taiwanese", "taiwanese123", "Алексей", "Кравцов", "kravc@gmail.com",3));
        usrs.add(new User("bobst", "bobst123", "Александр", "Пушкин", "a_pushkin@gmail.com", 4));
        usrs.add(new User("packaging", "packaging123", "Роман", "Скороходов", "skorohod@mail.ru", 5));
        usrs.add(new User("storage", "storage123", "Евгений", "Выходцев", "mmx@torba.net", 6));
    }

    public User save(User usr) {
        return null;
    }

    public User findOne(int id) {
        return null;
    }

    public User findOne(String login, String password) {
        for (User usr : usrs)
            if (usr.getLogin().equalsIgnoreCase(login))
                if (usr.getPassword().equals(password))
                    return usr;

        return null;
    }

    public List<User> findAll() {
        return null;
    }
}

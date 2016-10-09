package com.ksimeo.yanu.admin.dao;

import com.ksimeo.yanu.admin.models.User;

import java.util.List;

/**
 * @author Ksimeo. Created on 02.10.2016 at 20:32 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface UserDao {

    User findOne(String login, String password);
    List<User> findAll();
    User save(User usr);
}

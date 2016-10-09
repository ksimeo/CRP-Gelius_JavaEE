package com.ksimeo.yanu.api.dao;

import com.ksimeo.yanu.entities.models.User;

import java.util.List;

/**
 * @author Ksimeo. Created on 09.10.2016 at 15:31 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface UserDAO {

        User save(User usr);

        User findOne(int id);

        User findOne(String login, String password);

        List<User> findAll();
}

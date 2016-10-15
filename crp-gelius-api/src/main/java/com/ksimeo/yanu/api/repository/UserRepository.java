package com.ksimeo.yanu.api.repository;

import com.ksimeo.yanu.entities.models.User;

/**
 * @author Ksimeo. Created on 11.10.2016 at 15:19 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface UserRepository {
    User addUser(User user);
    User getUser(int id);
    User getUser(String login, String password);
    void delUser(int id);
}

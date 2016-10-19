package com.ksimeo.yanu.api.services;

import com.ksimeo.yanu.entities.gto.UserGTO;
import com.ksimeo.yanu.entities.models.User;

import java.util.List;

/**
 * @author Ksimeo. Created on 09.10.2016 at 15:16 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface UsersService {

    User addUser(User usr) throws Exception;
    User getUser(UserGTO userInfo) throws Exception;
    List<User> getUsers() throws Exception;
    List<User> getUsers(int role) throws Exception;
    void delUser(int id) throws Exception;
}

package com.ksimeo.yanu.admin.services;

import com.ksimeo.yanu.admin.gto.UserGTO;
import com.ksimeo.yanu.admin.models.User;

import java.util.List;

/**
 * @author Ksimeo. Created on 02.10.2016 at 20:23 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
public interface UserService {

    User getUser(UserGTO usrInfo);
    List<User> getAll();
    void createUser(UserGTO usrInfo) throws Exception;
}
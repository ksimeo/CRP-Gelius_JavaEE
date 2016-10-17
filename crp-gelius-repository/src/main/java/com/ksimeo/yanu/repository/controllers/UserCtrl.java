package com.ksimeo.yanu.repository.controllers;

import com.ksimeo.yanu.entities.gto.UserGTO;
import com.ksimeo.yanu.entities.models.User;
import com.ksimeo.yanu.repository.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Ksimeo. Created on 15.10.2016 at 11:13 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class UserCtrl {
    @Autowired
    private UserDAO usrDao;

    @RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return usrDao.save(user);
    }

    @RequestMapping(value = "/getallusers", method = RequestMethod.GET, consumes = "application/json")
    @ResponseBody
    public List<User> getAllUsers() {
        return (List<User>)usrDao.findAll();
    }

    @RequestMapping(value = "/getusrbyid/{id}", method = RequestMethod.GET, produces = "applicaion/json")
    @ResponseBody
    public User getUserById(@RequestBody int id) {
        return usrDao.findOne(id);
    }

    @RequestMapping(value = "/getusrbyloginpassw", method = RequestMethod.POST, consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public User getUserByLoginPassword(UserGTO userGTO) {
        return usrDao.findOne(userGTO.getLogin(), userGTO.getPassword());
    }

    @RequestMapping(value = "/deluser/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delUser(@RequestBody int id) {
        usrDao.delete(id);
    }
}

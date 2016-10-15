package com.ksimeo.yanu.impl.dao;

import com.ksimeo.yanu.entities.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Ksimeo. Created on 09.10.2016 at 15:31 for "crp-gelius" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface UserDAO extends CrudRepository<User, Integer> {

    @Query(value = "select * from users where login=:login, password=:password", nativeQuery = true)
    public User findOne(@Param("login") String login, @Param("password") String password);
}

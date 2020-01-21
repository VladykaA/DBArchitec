package com.architec.service.impl;

import com.architec.dao.UserDAO;
import com.architec.dao.mysql.MySQLUserDAO;
import com.architec.domain.User;
import com.architec.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements CRUDService<User> {

    @Autowired
    @Qualifier("mySQLUserDAO")
    private UserDAO userDAO;

    @Override
    public void save(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void update(User user) {

    }
}

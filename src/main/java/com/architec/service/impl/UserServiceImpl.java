package com.architec.service.impl;

import com.architec.dao.interfaces.CRUDUserDAO;
import com.architec.domain.User;
import com.architec.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements CRUDService<User> {

    @Autowired
    @Qualifier("mySQLCRUDUserDAO")
    private CRUDUserDAO userDAO;

    @Override
    public void save(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User getById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void update(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void delete(User user) {
        userDAO.deleteUser(user);
    }
}

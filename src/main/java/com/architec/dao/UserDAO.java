package com.architec.dao;

import com.architec.domain.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);
    User getUserById(int id);
    List<User> getAll();
    void updateUser(User user);
    void deleteUser(User user);

}

package com.architec.dao;

import com.architec.User;

public interface UserDAO {
    void saveUser(User user);
    void getUser(User user);
    void updateUser(User user);
    void deleteUser(User user);

}

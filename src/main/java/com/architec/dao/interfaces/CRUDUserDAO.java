package com.architec.dao.interfaces;

import com.architec.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CRUDUserDAO {
    void saveUser(User user);
    User getUserById(int id);
    List<User> getAll();
    void updateUser(User user);
    void deleteUser(User user);

}

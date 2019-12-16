package com.architec.dao.mysql;

import com.architec.EntityManager.EntityManagerUtil;
import com.architec.User;
import com.architec.dao.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MySQLUserDAO implements UserDAO {

    EntityManager em = EntityManagerUtil.getEntityManager();
    EntityTransaction transaction = em.getTransaction();

    @Override
    public void saveUser(User user) {
        transaction.begin();
        em.persist(user);
        transaction.commit();
        em.close();
    }

    @Override
    public User getUserById(int id){
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public List<User> getAll() {


        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

}

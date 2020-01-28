package com.architec.dao.mysql;

import com.architec.dao.interfaces.CRUDUserDAO;
import com.architec.util.EntityManagerUtil;
import com.architec.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class MySQLCRUDUserDAO implements CRUDUserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
//        EntityManager em = EntityManagerUtil.getEntityManager();

        /*EntityTransaction transaction = em.getTransaction();

        transaction.begin();*/

        em.persist(user);

//        transaction.commit();
    }

    @Override
    public User getUserById(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        User user = em.find(User.class, id);

        transaction.commit();

        return user;

    }

    @Override
    public List<User> getAll() {

        EntityManager em = EntityManagerUtil.getEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<User> query = builder.createQuery(User.class);

        Root<User> root = query.from(User.class);

        query.select(root);

        return em.createQuery(query).getResultList();
    }

    @Override
    public void updateUser(User user) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        User mergedUser = em.merge(user);

        em.persist(mergedUser);

        transaction.commit();

    }

    @Override
    public void deleteUser(User user) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        if (user != null) {
            transaction.begin();
            em.remove(user);
            transaction.commit();
        }
    }
}

package com.architec.dao.mysql;

import com.architec.Question;
import com.architec.dao.QuestionsManipulationDAO;
import com.architec.util.EntityManagerUtil;
import com.architec.User;
import com.architec.dao.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MySQLUserDAO implements UserDAO, QuestionsManipulationDAO {

    @Override
    public void saveUser(User user) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(user);

        transaction.commit();
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

    @Override
    public Question getQuestionById(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Question question = em.find(Question.class, id);

        transaction.commit();

        return question;
    }

    @Override
    public void updateQuestion(User user, Question question) {
        if (user.isAuthor()) {
            EntityManager em = EntityManagerUtil.getEntityManager();

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            Question mergedQuestion = em.merge(question);

            em.persist(mergedQuestion);

            transaction.commit();
        }
    }

    @Override
    public void deleteQuestion(User user, Question question) {
        if (user.isAuthor()) {
            EntityManager em = EntityManagerUtil.getEntityManager();

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(question);

            transaction.commit();
        }
    }
}

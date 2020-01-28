package com.architec.dao.mysql;

import com.architec.dao.interfaces.CRUDQuestionsDAO;
import com.architec.domain.Question;
import com.architec.domain.User;
import com.architec.util.EntityManagerUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MySQLQuestionDAO implements CRUDQuestionsDAO {

    @Override
    public void saveQuestion(Question question) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(question);

        transaction.commit();

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
    public List<Question> getAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Question> query = builder.createQuery(Question.class);

        Root<Question> root = query.from(Question.class);

        query.select(root);

        return em.createQuery(query).getResultList();
    }

    @Override
    public Question getQuestionByKey(String key) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Question question = em.find(Question.class, key);

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

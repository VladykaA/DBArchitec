package com.architec.dao.mysql;

import com.architec.dao.interfaces.CRUDQuestionnaireDAO;
import com.architec.domain.Questionnaire;
import com.architec.domain.User;
import com.architec.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MySQLQuestionnaireDAO implements CRUDQuestionnaireDAO {

    @Override
    public void saveQuestionnaire(Questionnaire questionnaire) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(questionnaire);

        transaction.commit();
    }

    @Override
    public Questionnaire getQuestionnaireById(int id) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Questionnaire questionnaire = em.find(Questionnaire.class, id);

        transaction.commit();

        return questionnaire;
    }

    @Override
    public Questionnaire getQuestionnaireByKey(String key) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Questionnaire questionnaire = em.find(Questionnaire.class, key);

        transaction.commit();

        return questionnaire;
    }

    @Override
    public List<Questionnaire> getAll() {

        EntityManager em = EntityManagerUtil.getEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Questionnaire> query = builder.createQuery(Questionnaire.class);

        Root<Questionnaire> root = query.from(Questionnaire.class);

        query.select(root);

        return em.createQuery(query).getResultList();
    }

    @Override
    public void updateQuestionnaire(User user, Questionnaire questionnaire) {

        if (user.isAuthor()){
            EntityManager em = EntityManagerUtil.getEntityManager();

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            Questionnaire mergedQuestionnaire = em.merge(questionnaire);

            em.persist(mergedQuestionnaire);

            transaction.commit();
        }
    }

    @Override
    public void deleteQuestionnaire(User user, Questionnaire questionnaire) {
        if (user.isAuthor()){
            EntityManager em = EntityManagerUtil.getEntityManager();

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(questionnaire);

            transaction.commit();
        }
    }
}

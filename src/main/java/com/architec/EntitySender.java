package com.architec;

import com.architec.EntityManager.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EntitySender {
    public static void main(String[] args) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

    /*    User u1 = new User("Sam", "123", true);

        Questionnaire questionnaire1 = new Questionnaire(u1);

        Question question1 = new Question("Tile-1","Some text", 1);

        u1.addQuestionnaire(questionnaire1);

        questionnaire1.addQuestionToQuestionnaire(question1);

        u1.addQuestion(question1);

        em.persist(u1);

        transaction.commit();*/

        em.close();

    }
}

package com.architec;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntitySender {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("shade_db_architecture");
        EntityManager em = factory.createEntityManager();
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
        factory.close();

    }
}

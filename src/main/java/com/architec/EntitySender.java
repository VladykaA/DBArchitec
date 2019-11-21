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

        User u1 = new User("Sam", "123");
        User u2 = new User("Ray", "321");

        Question q1 = new Question("Tile-1","Some text");
        Question q2 = new Question("Tile-2", "some additional text");

        u1.addQuestion(q1);
        u1.addQuestion(q2);

        u2.addQuestion(q1);

        em.persist(u1);
        em.persist(u2);

        transaction.commit();

        em.close();
        factory.close();

    }
}

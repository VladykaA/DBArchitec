package com.architec.EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

public class EntityManagerUtil {
    public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("shade_db_architecture");
    public static final ThreadLocal<EntityManager> THREAD_LOCAL = new ThreadLocal<>();

    public static EntityManager getEntityManager() {

        if (Objects.isNull(THREAD_LOCAL.get())) {
            EntityManager entityManager = FACTORY.createEntityManager();
            THREAD_LOCAL.set(entityManager);
        }

        return THREAD_LOCAL.get();
    }
}

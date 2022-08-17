package fr.m2i.jpahibernate.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionHelper {

    private static EntityManager entityManager = null;

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("site_commerce_pu");
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
            return entityManager;
        } else {
            return null;
        }
    }
}

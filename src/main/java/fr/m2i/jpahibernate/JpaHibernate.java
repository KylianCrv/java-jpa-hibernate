package fr.m2i.jpahibernate;

import fr.m2i.jpahibernate.helper.SessionHelper;
import javax.persistence.EntityManager;

public class JpaHibernate {

    public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();

        System.out.println("Mon traitement...");

        entityManager.close();
    }
}

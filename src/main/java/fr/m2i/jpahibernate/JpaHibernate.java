package fr.m2i.jpahibernate;

import fr.m2i.jpahibernate.helper.SessionHelper;
import fr.m2i.jpahibernate.model.Role;
import javax.persistence.EntityManager;

public class JpaHibernate {

    public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();

        Role firstRole = entityManager.find(Role.class, 2L);

        if (firstRole != null) {
            System.out.println(firstRole);
        }

        entityManager.close();
    }
}

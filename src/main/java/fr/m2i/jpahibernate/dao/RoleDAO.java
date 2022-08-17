package fr.m2i.jpahibernate.dao;

import fr.m2i.jpahibernate.helper.SessionHelper;
import fr.m2i.jpahibernate.model.Role;
import javax.persistence.*;

public class RoleDAO {

    EntityManager entityManager = SessionHelper.getEntityManager();

    public Role findById(Long id) {
        Role role = entityManager.find(Role.class, id);
        return role;
    }

    public void create(Role role) {
        EntityTransaction trans = null;
        try {
            trans = entityManager.getTransaction();
            trans.begin();
            role = new Role();
            entityManager.persist(role);
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
        }
    }
//    public void update(Long id, Role role) {
//        EntityTransaction trans = null;
//        try {
//            trans = entityManager.getTransaction();
//            trans.begin();
//            Role updateCustomer = entityManager.merge(role);
//            updateCustomer.setDescription(description);
//
//            trans.commit();
//        } catch (Exception e) {
//            if (trans != null) {
//                trans.rollback();
//            }
//        }
//    }
}

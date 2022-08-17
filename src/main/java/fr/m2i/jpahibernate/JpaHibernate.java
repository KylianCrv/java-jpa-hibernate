package fr.m2i.jpahibernate;

import fr.m2i.jpahibernate.dao.RoleDAO;
import fr.m2i.jpahibernate.helper.SessionHelper;
import fr.m2i.jpahibernate.model.Role;
import javax.persistence.EntityManager;

public class JpaHibernate {

    public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        RoleDAO roleDao = new RoleDAO();

        //Create
        Role roleAdmin = new Role("Le rôle admin", "ADMIN");
        roleDao.create(roleAdmin);

        //find
        Role founded = roleDao.findById(1L);
        System.out.println("Role created  : " + founded);

        //update
        Role roleData = new Role();
        roleData.setDescription("Le role admin implique de grandes résponsabilités");

        roleDao.update(1L, roleData);

        //find
        Role updated = roleDao.findById(1L);
        System.out.println("Role updated : " + updated);

        entityManager.close();
    }
}

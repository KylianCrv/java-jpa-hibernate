package fr.m2i.jpahibernate;

import fr.m2i.jpahibernate.dao.RoleDAO;
import fr.m2i.jpahibernate.helper.SessionHelper;
import fr.m2i.jpahibernate.model.Role;
import java.util.List;
import javax.persistence.EntityManager;

public class JpaHibernate {

    public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        RoleDAO roleDao = new RoleDAO();

        //Create
//        Role roleUser = new Role("Le rôle user", "USER");
//        roleDao.create(roleUser);
//        //find
//        Role founded = roleDao.findById(1L);
//        System.out.println("Role created  : " + founded);
//
//        //update
//        Role roleData = new Role();
//        roleData.setDescription("Le role admin implique de grandes résponsabilités");
//
//        roleDao.update(1L, roleData);
//
//        //find
//        Role updated = roleDao.findById(1L);
//        System.out.println("Role updated : " + updated);
        //liste
        List<Role> roles = roleDao.findAll();
        for (Role r : roles) {
            System.out.println(r);
        }
        entityManager.close();
    }
}

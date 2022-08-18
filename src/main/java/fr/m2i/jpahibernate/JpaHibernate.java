package fr.m2i.jpahibernate;

import fr.m2i.jpahibernate.dao.RoleDAO;
import fr.m2i.jpahibernate.dao.UtilisateurDAO;
import fr.m2i.jpahibernate.helper.SessionHelper;
import fr.m2i.jpahibernate.model.Role;
import fr.m2i.jpahibernate.model.Utilisateur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

public class JpaHibernate {

    public static void main(String[] args) throws ParseException {
        EntityManager entityManager = SessionHelper.getEntityManager();
        RoleDAO roleDao = new RoleDAO();

        //***************ROLE*****************
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
//        List<Role> roles = roleDao.findAll();
//        for (Role r : roles) {
//            System.out.println(r);
//        }
        //*****************USER**************
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

        Role roleAdmin = roleDao.findById(1L);
        Role roleUser = roleDao.findById(2L);

        Date dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse("09/10/1996");

        //Create
//        Utilisateur newUser = new Utilisateur(true, "Monsieur", new Date(), new Date(), dateNaissance, "Sheeeesh", true, "zozor", "Carvalho", "Kylian", roleAdmin);
//        utilisateurDAO.create(newUser);
//Find
        Utilisateur founded = utilisateurDAO.findById(1L);
        System.out.println("User created  : " + founded);

        //FindAll
        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        for (Utilisateur u : utilisateurs) {
            System.out.println(u);
        }

        //update
        Utilisateur userData = new Utilisateur();
        userData.setMotPasse("toto");

        utilisateurDAO.update(1L, userData);

        entityManager.close();
    }
}

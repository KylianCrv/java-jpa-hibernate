package fr.m2i.jpahibernate;

import fr.m2i.jpahibernate.dao.AdresseDAO;
import fr.m2i.jpahibernate.dao.ProduitDAO;
import fr.m2i.jpahibernate.dao.RoleDAO;
import fr.m2i.jpahibernate.dao.UtilisateurDAO;
import fr.m2i.jpahibernate.helper.SessionHelper;
import fr.m2i.jpahibernate.model.Adresse;
import fr.m2i.jpahibernate.model.Produit;
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
//        RoleDAO roleDao = new RoleDAO();
//
//        //***************ROLE*****************
//        //Create
////        Role roleUser = new Role("Le rôle user", "USER");
////        roleDao.create(roleUser);
////        //find
////        Role founded = roleDao.findById(1L);
////        System.out.println("Role created  : " + founded);
////
////        //update
////        Role roleData = new Role();
////        roleData.setDescription("Le role admin implique de grandes résponsabilités");
////
////        roleDao.update(1L, roleData);
////
////        //find
////        Role updated = roleDao.findById(1L);
////        System.out.println("Role updated : " + updated);
//        //liste
////        List<Role> roles = roleDao.findAll();
////        for (Role r : roles) {
////            System.out.println(r);
////        }
//        //*****************USER**************
//        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
////
////        Role roleAdmin = roleDao.findById(1L);
////        Role roleUser = roleDao.findById(2L);
////
////        Date dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse("09/10/1996");
////
////        //Create
//////        Utilisateur newUser = new Utilisateur(true, "Monsieur", new Date(), new Date(), dateNaissance, "Sheeeesh", true, "zozor", "Carvalho", "Kylian", roleAdmin);
////        Utilisateur newUser2 = new Utilisateur(true, "Madame", new Date(), new Date(), dateNaissance, "x", false, "password", "x_x", "x", roleUser);
//////        utilisateurDAO.create(newUser);
////        utilisateurDAO.create(newUser2);
//////Find
////        Utilisateur founded = utilisateurDAO.findById(1L);
////        System.out.println("User created  : " + founded);
////
////        //FindAll
////        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
////        for (Utilisateur u : utilisateurs) {
////            System.out.println(u);
////        }
////
////        //update
////        Utilisateur userData = new Utilisateur();
////        userData.setMotPasse("toto");
////
////        utilisateurDAO.update(1L, userData);
////*********ADRESSE**********
//        AdresseDAO adresseDao = new AdresseDAO();
//
//        Utilisateur user1 = utilisateurDAO.findById(1L);
//        Utilisateur user2 = utilisateurDAO.findById(2L);
//
////Create
////        Adresse addr1 = new Adresse(user1, "36000", "France", true, "11, Rue Jean Bouin", "Le Poinçonnet");
////        Adresse addr2 = new Adresse(user2, "75000", "France", true, "18, Rue Paul Verlaine", "Paris");
////        Adresse addr3 = new Adresse(user1, "75000", "France", true, "75, Allée Paul Rue", "Paris");
////        adresseDao.create(addr1);
////        adresseDao.create(addr2);
////        adresseDao.create(addr3);
//        //find
//        Adresse founded = adresseDao.findById(2L);
//        System.out.println("Adresse created  : " + founded);
//
//        //find all
//        List<Adresse> adresses = adresseDao.findAll();
//        for (Adresse a : adresses) {
//            System.out.println(a);
//        }
//
//        //update
////        Adresse adresseData = new Adresse();
////        adresseData.setVille("Marseille");
////        adresseDao.update(3L, adresseData);
//        //findByUtiliisateur
//        List<Adresse> adressesById = adresseDao.findByUtilisateur(user1);
//        for (Adresse a : adressesById) {
//            System.out.println(a);
//        }

//********************PRODUIT**********************
        ProduitDAO produitDAO = new ProduitDAO();

//        Produit founded = produitDAO.findById(3L);
//        System.out.println("Produit created  : " + founded);
//
//        Produit product1 = new Produit(true, "x", "x", 78.98f, "x_x", 56);
//        produitDAO.create(product1);
//        Produit produitData = new Produit();
//        produitData.setStock(98);
//        produitDAO.update(17L, produitData);
//        Produit founded = produitDAO.findById(17L);
//        produitDAO.delete(founded);
//        produitDAO.findByMostQuantity();
        System.out.println(produitDAO.findByMostQuantity());
        entityManager.close();
    }
}

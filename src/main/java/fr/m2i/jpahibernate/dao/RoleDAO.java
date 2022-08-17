package fr.m2i.jpahibernate.dao;

import fr.m2i.jpahibernate.helper.SessionHelper;
import fr.m2i.jpahibernate.model.Role;
import java.util.List;
import javax.persistence.*;

public class RoleDAO {

    private final EntityManager entityManager;

    public RoleDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }

    public Role findById(Long id) {
        Role founded = entityManager.find(Role.class, id);

        if (founded == null) {
            System.out.println("Attention le role avec l'id : " + id + " n'existe pas.");
        }

        return founded;
    }

    public void create(Role role) {
        //Vérifier le param role

        if (role == null) {
            System.out.println("L'objet role ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {

            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(role);

            tx.commit();

        } catch (Exception e) {
            System.out.println("Une erreur s'est produite durant la création du rôle");
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    //Différentes manières : lister les param modifiables
    // public void update(Long id, Strind description,...)
    //On utilise l'id pour récuperer la donnée
    //roleToUpdate.setIdentifiant(identifiant)
    //*****
    //Autre manière : Avoir l'id + les données à modifier encapsulées dans l'entity
    //public void update(Long id, String description)
    //On utilise l'id pour récuperer la donnée
    // => set les données
    //roleToUpdate.copy(roleData) => set uniquement les données qui ne sont pas null
    public void update(Long id, Role roleData) {

        Role roleToUpdate = entityManager.find(Role.class, id);

        if (roleToUpdate == null) {
            System.out.println("Attention le role avec l'id : " + id + " n'existe pas.");
            return;
        }

        roleToUpdate.copy(roleData);

        EntityTransaction tx = null;

        try {

            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(roleToUpdate);

            tx.commit();

        } catch (Exception e) {
            System.out.println("Une erreur s'est produite durant la modification du rôle");
            if (tx != null) {
                tx.rollback();
            }
        }

    }

    public List<Role> findAll() {
        Query findAllQuerry = entityManager.createQuery("SELECT r FROM Role r");
        return findAllQuerry.getResultList();
    }
}

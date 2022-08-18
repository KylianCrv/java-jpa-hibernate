package fr.m2i.jpahibernate.dao;

import fr.m2i.jpahibernate.helper.SessionHelper;
import fr.m2i.jpahibernate.model.Utilisateur;
import java.util.List;
import javax.persistence.*;

public class UtilisateurDAO {

    private final EntityManager entityManager;

    public UtilisateurDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }

    public Utilisateur findById(Long id) {
        Utilisateur founded = entityManager.find(Utilisateur.class, id);

        if (founded == null) {
            System.out.println("Attention l'utilisateur avec l'id : " + id + " n'existe pas.");
        }

        return founded;
    }

    public void create(Utilisateur utilisateur) {
        //Vérifier le param utilisateur

        if (utilisateur == null) {
            System.out.println("L'objet utilisateur ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {

            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(utilisateur);

            tx.commit();

        } catch (Exception e) {
            System.out.println("Une erreur s'est produite durant la création de l'utilisateur");
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void update(Long id, Utilisateur userData) {

        Utilisateur userToUpdate = entityManager.find(Utilisateur.class, id);

        if (userToUpdate == null) {
            System.out.println("Attention l'utilisateur avec l'id : " + id + " n'existe pas.");
            return;
        }

        userToUpdate.copy(userData);

        EntityTransaction tx = null;

        try {

            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(userToUpdate);

            tx.commit();

        } catch (Exception e) {
            System.out.println("Une erreur s'est produite durant la modification de l'utilisateur");
            if (tx != null) {
                tx.rollback();
            }
        }

    }

    public List<Utilisateur> findAll() {
        Query findAllQuerry = entityManager.createQuery("SELECT u FROM Utilisateur u");
        return findAllQuerry.getResultList();
    }
}

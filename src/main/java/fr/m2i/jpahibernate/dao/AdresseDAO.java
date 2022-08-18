package fr.m2i.jpahibernate.dao;

import fr.m2i.jpahibernate.helper.SessionHelper;
import fr.m2i.jpahibernate.model.Adresse;
import fr.m2i.jpahibernate.model.Utilisateur;
import java.util.List;
import javax.persistence.*;

public class AdresseDAO {

    private final EntityManager entityManager;

    public AdresseDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }

    public Adresse findById(Long id) {
        Adresse founded = entityManager.find(Adresse.class, id);

        if (founded == null) {
            System.out.println("Attention l'adresse avec l'id : " + id + " n'existe pas.");
        }

        return founded;
    }

    public void create(Adresse adresse) {
        //Vérifier le param adresse

        if (adresse == null) {
            System.out.println("L'objet adresse ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {

            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(adresse);

            tx.commit();

        } catch (Exception e) {
            System.out.println("Une erreur s'est produite durant la création de l'adresse");
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void update(Long id, Adresse adresseData) {

        Adresse adresseToUpdate = entityManager.find(Adresse.class, id);

        if (adresseToUpdate == null) {
            System.out.println("Attention l'adresse avec l'id : " + id + " n'existe pas.");
            return;
        }

        adresseToUpdate.copy(adresseData);

        EntityTransaction tx = null;

        try {

            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(adresseToUpdate);

            tx.commit();

        } catch (Exception e) {
            System.out.println("Une erreur s'est produite durant la modification de l'adresse");
            if (tx != null) {
                tx.rollback();
            }
        }

    }

    public List<Adresse> findAll() {
        Query findAllQuerry = entityManager.createQuery("SELECT a FROM Adresse a");
        return findAllQuerry.getResultList();
    }

    public List<Adresse> findByUtilisateur(Utilisateur user) {
        Query findByUserQuerry = entityManager.createQuery("SELECT a FROM Adresse a WHERE a.user =?1");
        findByUserQuerry.setParameter(1, user);
        return findByUserQuerry.getResultList();
    }

}

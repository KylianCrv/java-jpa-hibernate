package fr.m2i.jpahibernate.dao;

import fr.m2i.jpahibernate.helper.SessionHelper;
import fr.m2i.jpahibernate.model.Produit;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ProduitDAO {

    private final EntityManager entityManager;

    public ProduitDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }

    public Produit findById(Long id) {
        Produit founded = entityManager.find(Produit.class, id);

        if (founded == null) {
            System.out.println("Attention le produit avec l'id : " + id + " n'existe pas.");
        }
        return founded;
    }

    public List<Produit> findAll() {
        Query findAllQuerry = entityManager.createQuery("SELECT p FROM Produit p");
        return findAllQuerry.getResultList();
    }

    public List<Produit> findByNom(String name) {
        Query findByName = entityManager.createQuery("SELECT p FROM Produit p WHERE p.nom = ?1");
        findByName.setParameter(1, name);
        return findByName.getResultList();
    }

    public List<Produit> findByDescription(String description) {
        Query findByDescription = entityManager.createQuery("SELECT p FROM Produit p WHERE p.description = ?1");
        findByDescription.setParameter(1, description);
        return findByDescription.getResultList();
    }

    public List<Produit> findByPrix(Float prix) {
        Query findByprix = entityManager.createQuery("SELECT p FROM Produit p WHERE p.prix = ?1");
        findByprix.setParameter(1, prix);
        return findByprix.getResultList();
    }

    public List<Produit> findByReference(String reference) {
        Query findByReference = entityManager.createQuery("SELECT p FROM Produit p WHERE p.reference = ?1");
        findByReference.setParameter(1, reference);
        return findByReference.getResultList();
    }

    public Produit findByMostQuantity() {
        TypedQuery<Produit> findByMostQuantity = entityManager.createQuery("SELECT p FROM Produit p WHERE p.stock ="
                + "(SELECT Max(p.stock) FROM Produit p)",
                Produit.class);
        return findByMostQuantity.getSingleResult();

    }

    public void create(Produit produit) {
        //Vérifier le param produit

        if (produit == null) {
            System.out.println("L'objet produit ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {

            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(produit);

            tx.commit();

        } catch (Exception e) {
            System.out.println("Une erreur s'est produite durant la création du produit");
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void update(Long id, Produit produitData) {

        Produit produitToUpdate = entityManager.find(Produit.class, id);

        if (produitToUpdate == null) {
            System.out.println("Attention le produit avec l'id : " + id + " n'existe pas.");
            return;
        }

        produitToUpdate.copy(produitData);

        EntityTransaction tx = null;

        try {

            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(produitToUpdate);

            tx.commit();

        } catch (Exception e) {
            System.out.println("Une erreur s'est produite durant la modification du produit");
            if (tx != null) {
                tx.rollback();
            }
        }

    }

    public void delete(Produit produit) {

        Produit produitToDelete = entityManager.find(Produit.class, produit.getId());

        if (produitToDelete == null) {
            System.out.println("Attention le produit avec l'id : " + produit.getId() + " n'existe pas.");
            return;
        }

        EntityTransaction tx = null;

        try {

            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.remove(produitToDelete);

            tx.commit();

        } catch (Exception e) {
            System.out.println("Une erreur s'est produite durant la suppression du produit");
            if (tx != null) {
                tx.rollback();
            }
        }

    }
}

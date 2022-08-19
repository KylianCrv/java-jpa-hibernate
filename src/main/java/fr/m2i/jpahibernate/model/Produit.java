package fr.m2i.jpahibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id_produit")
    private Long id;

    @Column(
            name = "active",
            columnDefinition = "TINYINT(1) DEFAULT 1"
    )
    private Boolean active;

    @Column(
            name = "description",
            columnDefinition = "TEXT")
    private String description;

    @Column(
            name = "nom",
            length = 100)
    private String nom;

    @Column(
            name = "prix")
    private Float prix;

    @Column(
            name = "reference",
            length = 100)
    private String reference;

    @Column(
            name = "stock",
            length = 11)
    private Integer stock;

    public Produit() {
    }

    public Produit(Boolean active, String description, String nom, Float prix, String reference, Integer stock) {
        this.active = active;
        this.description = description;
        this.nom = nom;
        this.prix = prix;
        this.reference = reference;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + id
                + ", active=" + active
                + ", description=" + description
                + ", nom=" + nom
                + ", prix=" + prix
                + ", reference=" + reference
                + ", stock=" + stock
                + '}';
    }

    public void copy(Produit produitData) {

        if (produitData.getActive() != null) {
            this.setActive(produitData.getActive());
        }

        if (produitData.getDescription() != null) {
            this.setDescription(produitData.getDescription());
        }

        if (produitData.getNom() != null) {
            this.setNom(produitData.getNom());
        }

        if (produitData.getPrix() != null) {
            this.setPrix(produitData.getPrix());
        }
        if (produitData.getReference() != null) {
            this.setReference(produitData.getReference());
        }
        if (produitData.getStock() != null) {
            this.setStock(produitData.getStock());
        }
    }
}

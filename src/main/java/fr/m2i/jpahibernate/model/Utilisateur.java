package fr.m2i.jpahibernate.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id_utilisateur")
    private Long id;

    @Column(
            name = "actif",
            columnDefinition = "TINYINT(1)"
    )
    private boolean actif;

    @Column(
            name = "civilite",
            length = 100)
    private String civilite;

    @Column(
            name = "date_creation",
            columnDefinition = "TIMESTAMP")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Column(
            name = "date_modification",
            columnDefinition = "TIMESTAMP")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateModification;

    @Column(
            name = "date_naissance",
            columnDefinition = "TIMESTAMP")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateNaissance;

    @Column(
            name = "identifiant",
            length = 100)
    private String identifiant;

    @Column(
            name = "marquer_effacer",
            columnDefinition = "TINYINT(1)"
    )
    private boolean marquerEffacer;

    @Column(
            name = "mot_passe",
            length = 100)
    private String motPasse;

    @Column(
            name = "nom",
            length = 100)
    private String nom;

    @Column(
            name = "prenom",
            length = 100)
    private String prenom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role")
    private Role role;

    //Constructeurs
    public Utilisateur() {
    }

    public Utilisateur(boolean actif, String civilite, Date dateCreation, Date dateModification, Date dateNaissance, String identifiant, boolean marquerEffacer, String motPasse, String nom, String prenom, Role role) {
        this.actif = actif;
        this.civilite = civilite;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.dateNaissance = dateNaissance;
        this.identifiant = identifiant;
        this.marquerEffacer = marquerEffacer;
        this.motPasse = motPasse;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    //Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public boolean isMarquerEffacer() {
        return marquerEffacer;
    }

    public void setMarquerEffacer(boolean marquerEffacer) {
        this.marquerEffacer = marquerEffacer;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

package fr.m2i.jpahibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id_utilisateur")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

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
            columnDefinition = "TINYINT(1) DEFAULT 0"
    )
    private Boolean marquerEffacer;

    @Column(
            name = "actif",
            columnDefinition = "TINYINT(1) DEFAULT 1"
    )
    private Boolean actif;

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

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Adresse> adresses;

    //Constructeurs
    public Utilisateur() {
    }

    public Utilisateur(Boolean actif, String civilite, Date dateCreation, Date dateModification, Date dateNaissance, String identifiant, Boolean marquerEffacer, String motPasse, String nom, String prenom, Role role) {
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
    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Boolean isMarquerEffacer() {
        return marquerEffacer;
    }

    public void setMarquerEffacer(Boolean marquerEffacer) {
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

    @Override
    public String toString() {
        return "Utilisateur{" + "idUtilisateur=" + id
                + ", role=" + role
                + ", civilite=" + civilite
                + ", nom=" + nom
                + ", prenom=" + prenom
                + ", identifiant=" + identifiant
                + ", motPasse=" + motPasse
                + ", actif=" + actif
                + ", marquerEffacer=" + marquerEffacer
                + ", dateCreation=" + dateCreation
                + ", dateModification=" + dateModification
                + ", dateNaissance=" + dateNaissance + '}';
    }

    public void addAdresse(Adresse adresse) {

        if (adresse == null) {
            return;
        }

        if (adresses == null) {
            adresses = new ArrayList();
        }

        adresses.add(adresse);
        adresse.setUser(this);
    }

    public void removeAdresse(Adresse adresse) {
        adresse.setUser(null);

        if (adresses != null) {
            adresses.remove(adresse);
        }
    }

    public void copy(Utilisateur utilisateurData) {

        if (utilisateurData.getCivilite() != null) {
            this.setCivilite(utilisateurData.getCivilite());
        }
        if (utilisateurData.getNom() != null) {
            this.setNom(utilisateurData.getNom());
        }
        if (utilisateurData.getPrenom() != null) {
            this.setPrenom(utilisateurData.getPrenom());
        }
        if (utilisateurData.getIdentifiant() != null) {
            this.setIdentifiant(utilisateurData.getIdentifiant());
        }
        if (utilisateurData.getMotPasse() != null) {
            this.setMotPasse(utilisateurData.getMotPasse());
        }
        if (utilisateurData.isActif() != null) {
            this.setActif(utilisateurData.isActif());
        }
        if (utilisateurData.isMarquerEffacer() != null) {
            this.setMarquerEffacer(utilisateurData.isMarquerEffacer());
        }
        if (utilisateurData.getDateCreation() != null) {
            this.setDateCreation(utilisateurData.getDateCreation());
        }
        if (utilisateurData.getDateModification() != null) {
            this.setDateModification(utilisateurData.getDateModification());
        }
        if (utilisateurData.getDateNaissance() != null) {
            this.setDateNaissance(utilisateurData.getDateNaissance());
        }

    }
}

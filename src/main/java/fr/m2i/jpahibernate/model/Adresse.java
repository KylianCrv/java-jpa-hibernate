package fr.m2i.jpahibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "adresses")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id_adresse")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur user;

    @Column(
            name = "code_postal",
            length = 100)
    private String codePostal;

    @Column(
            name = "pays",
            length = 100)
    private String pays;

    @Column(
            name = "principale",
            columnDefinition = "TINYINT(1) DEFAULT 1"
    )
    private Boolean principale;

    @Column(
            name = "rue",
            length = 100)
    private String rue;

    @Column(
            name = "ville",
            length = 100)
    private String ville;

    public Adresse() {
    }

    public Adresse(Utilisateur user, String codePostal, String pays, Boolean principale, String rue, String ville) {
        this.user = user;
        this.codePostal = codePostal;
        this.pays = pays;
        this.principale = principale;
        this.rue = rue;
        this.ville = ville;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" + "idAdresse=" + id
                + ", user=" + user
                + ", code postal=" + codePostal
                + ", pays=" + pays
                + ", adresse principale=" + principale
                + ", rue=" + rue
                + ", ville=" + ville
                + '}';
    }

    public void copy(Adresse adresseData) {

        if (adresseData.getCodePostal() != null) {
            this.setCodePostal(adresseData.getCodePostal());
        }

        if (adresseData.getPays() != null) {
            this.setPays(adresseData.getPays());
        }

        if (adresseData.getPrincipale() != null) {
            this.setPrincipale(adresseData.getPrincipale());
        }

        if (adresseData.getRue() != null) {
            this.setRue(adresseData.getRue());
        }

        if (adresseData.getVille() != null) {
            this.setVille(adresseData.getVille());
        }

    }
}

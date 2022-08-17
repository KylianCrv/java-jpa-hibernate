package fr.m2i.jpahibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id_role")
    private Long id;

    @Column(
            name = "description",
            columnDefinition = "TEXT")
    private String description;

    @Column(
            name = "identifiant",
            length = 50)
    private String identifiant;

    public Role() {
    }

    public Role(Long id, String description, String identifiant) {
        this.id = id;
        this.description = description;
        this.identifiant = identifiant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", identifiant=" + identifiant + ", description=" + description + '}';
    }
}

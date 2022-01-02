package fr.vt.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "ressources_etudiants")
@AttributeOverride(name = "id", column = @Column(name = "codeetudiant"))
public class Student extends Resource {

    @Column(name = "prenom")
    private String firstName;

    @Column(name = "nom")
    private String lastName;

    @ManyToMany
    @JoinTable(name = "ressources_groupes_etudiants", joinColumns = @JoinColumn(name = "codeetudiant"), inverseJoinColumns = @JoinColumn(name = "codegroupe"))
    @JsonIgnoreProperties("students")
    private List<Group> groups;
}

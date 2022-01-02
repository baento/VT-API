package fr.vt.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ressources_groupes")
@AttributeOverride(name = "id", column = @Column(name = "codegroupe"))
public class Group extends Resource {

    @Column(name = "nom")
    private String name;

    @Column(name = "identifiant")
    private String handle;

    @ManyToMany(mappedBy = "groups")
    @JsonIgnoreProperties("groups")
    private List<Student> students;

    @ManyToMany(mappedBy = "groups")
    @JsonIgnoreProperties("groups")
    private List<Reservation> reservations;
    
    @ManyToMany(mappedBy = "groups")
    @JsonIgnoreProperties("groups")
    private List<Seance> seances;
}

package fr.vt.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "matieres")
@AttributeOverride(name = "id", column = @Column(name = "codematiere"))
public class Subject extends Resource {

    @Column(name = "nom")
    private String name;

    @Column(name = "identifiant")
    private String handle;

    @Column(name = "codeCNU")
    private int cnu;

    @OneToMany(mappedBy = "subject")
    @JsonBackReference
    private List<Course> courses;
}

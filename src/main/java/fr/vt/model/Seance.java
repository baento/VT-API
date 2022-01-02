package fr.vt.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@Entity
@AttributeOverride(name = "id", column = @Column(name = "codeseance"))
@Table(name = "seances")
public class Seance extends Activity {
    @ManyToOne
    @JoinColumn(name="codeenseignement", referencedColumnName="codeenseignement", nullable=false)
    @JsonManagedReference
    private Course course;

    @ManyToOne
    @JoinTable(name = "seances_salles", joinColumns = @JoinColumn(name = "codeseance"), inverseJoinColumns = @JoinColumn(name = "coderessource"))
    @JsonManagedReference
    private Location location;

    @ManyToOne
    @JoinTable(name = "seances_profs", joinColumns = @JoinColumn(name = "codeseance"), inverseJoinColumns = @JoinColumn(name = "coderessource"))
    @JsonManagedReference
    private Personnel teacher;

    @ManyToMany
    @JoinTable(name = "seances_groupes", joinColumns = @JoinColumn(name = "codeseance"), inverseJoinColumns = @JoinColumn(name = "coderessource"))
    @JsonIgnoreProperties("seances")
    private List<Group> groups;
}

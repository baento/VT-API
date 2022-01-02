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
@AttributeOverride(name = "id", column = @Column(name = "codereservation"))
@Table(name = "reservations")
public class Reservation extends Activity {

    @ManyToOne
    @JoinTable(name = "reservations_enseignements", joinColumns = @JoinColumn(name = "codereservation"), inverseJoinColumns = @JoinColumn(name = "coderessource"))
    @JsonManagedReference
    private Course course;

    @ManyToOne
    @JoinTable(name = "reservations_salles", joinColumns = @JoinColumn(name = "codereservation"), inverseJoinColumns = @JoinColumn(name = "coderessource"))
    @JsonManagedReference
    private Location location;


    @ManyToOne
    @JoinTable(name = "reservations_profs", joinColumns = @JoinColumn(name = "codereservation"), inverseJoinColumns = @JoinColumn(name = "coderessource"))
    @JsonManagedReference
    private Personnel teacher;

    @ManyToMany
    @JoinTable(name = "reservations_groupes", joinColumns = @JoinColumn(name = "codereservation"), inverseJoinColumns = @JoinColumn(name = "coderessource"))
    @JsonIgnoreProperties("reservations")
    private List<Group> groups;
}

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
@Table(name = "ressources_profs")
@AttributeOverride(name = "id", column = @Column(name = "codeprof"))
public class Personnel extends Resource {

    @Column(name = "prenom")
    private String firstName;

    @Column(name = "nom")
    private String lastName;

    @OneToMany(mappedBy = "teacher")
    @JsonBackReference
    private List<Seance> seances;

    @OneToMany(mappedBy = "teacher")
    @JsonBackReference
    private List<Reservation> reservations;
}

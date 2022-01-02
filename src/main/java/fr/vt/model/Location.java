package fr.vt.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "ressources_salles")
@AttributeOverride(name = "id", column = @Column(name = "codesalle"))
public class Location extends Resource {

    @Column(name = "nom")
    private String name;

    @Column(name = "capacite")
    private int capacity;
}

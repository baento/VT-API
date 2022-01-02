package fr.vt.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "enseignements")
@AttributeOverride(name = "id", column = @Column(name = "codeenseignement"))
public class Course extends Resource {
    
    @Column(name = "nom")
    private String name;

    @ManyToOne
    @JoinColumn(name="codematiere", referencedColumnName="codematiere", nullable=false)
    @JsonManagedReference
    private Subject subject;    
}

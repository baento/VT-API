package fr.vt.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public abstract class Resource {
    @Id
    @GeneratedValue
    private Integer id;

    @CreationTimestamp
    @Column(name = "datecreation")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "datemodif")
    private LocalDateTime updateDate;

    private boolean deleted;
}

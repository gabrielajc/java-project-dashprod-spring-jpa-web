package com.br.dashProd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "materia")
public class MateriaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    String name;

}
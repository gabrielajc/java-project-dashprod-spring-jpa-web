package com.br.dashProd.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class LinhaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    String conteudo;

    @Column(nullable = false, length = 150)
    String materia;

    @Column(nullable = false)
    int pomodoros;

    @Column(nullable = false)
    LocalDate date;

}

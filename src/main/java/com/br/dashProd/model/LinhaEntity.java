package com.br.dashProd.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

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

    @ManyToMany
    @JoinColumn(name = "materia_id", nullable = false)
    Set<MateriaEntity> materia;

    @Column(nullable = false)
    int pomodoros;

    @Column(nullable = false)
    LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;


    public LinhaEntity(String conteudo, Set<MateriaEntity> materia, int pomodoros, LocalDate date) {
        this.conteudo = conteudo;
        this.materia = materia;
        this.pomodoros = pomodoros;
        this.date = date;
    }
}

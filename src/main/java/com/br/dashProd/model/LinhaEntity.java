package com.br.dashProd.model;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getPomodoros() {
        return pomodoros;
    }

    public void setPomodoros(int pomodoros) {
        this.pomodoros = pomodoros;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

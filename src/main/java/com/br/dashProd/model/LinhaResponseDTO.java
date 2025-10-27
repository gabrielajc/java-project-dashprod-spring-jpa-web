package com.br.dashProd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LinhaResponseDTO(Long id, String conteudo, String materia, int pomodoros, LocalDate date) {

    public static LinhaResponseDTO fromEntity(LinhaEntity linhaEntity){
        LinhaResponseDTO linhaResponse =
                new LinhaResponseDTO(
                        linhaEntity.getId(),
                        linhaEntity.getConteudo(),
                        linhaEntity.getMateria(),
                        linhaEntity.getPomodoros(),
                        linhaEntity.getDate());

        return linhaResponse;

    };

}

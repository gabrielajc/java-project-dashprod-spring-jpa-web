package com.br.dashProd.dtos;


import com.br.dashProd.model.LinhaEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SessionStudyResponseDTO(Long id, String conteudo, Set<String> materia, int pomodoros, LocalDateTime date) {

}
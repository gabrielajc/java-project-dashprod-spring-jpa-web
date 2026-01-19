package com.br.dashProd.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StudySessionRequestDTO(@NotNull String conteudo, @NotNull Long materiaId, @NotNull @Min(1L) @Max(20L) int pomodoros) {

}

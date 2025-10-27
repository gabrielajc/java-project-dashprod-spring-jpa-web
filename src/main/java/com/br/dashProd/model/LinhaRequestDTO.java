package com.br.dashProd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LinhaRequestDTO(@NotNull String conteudo, @NotNull String materia, @NotNull @Min(1L) @Max(20L) int pomodoros, @NotNull LocalDate date) {
}

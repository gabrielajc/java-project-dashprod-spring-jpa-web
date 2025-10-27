package com.br.dashProd.service;

import com.br.dashProd.model.LinhaEntity;
import com.br.dashProd.model.LinhaRequestDTO;
import com.br.dashProd.model.LinhaResponseDTO;
import com.br.dashProd.respository.LinhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinhaService {
    private final LinhaRepository linhaRepository;

    public LinhaService(LinhaRepository linhaRepository) {
        this.linhaRepository = linhaRepository;
    }

    public List<LinhaResponseDTO> listLinhas() {
        return linhaRepository.findAll().stream()
                .map(LinhaResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public LinhaEntity saveLinhas(LinhaRequestDTO linhaRequestDTO) {
        LinhaEntity newLine = new LinhaEntity(
                linhaRequestDTO.conteudo(),
                linhaRequestDTO.materia(),
                linhaRequestDTO.pomodoros(),
                linhaRequestDTO.date()
        );
        return linhaRepository.save(newLine);
    }
}

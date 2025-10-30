package com.br.dashProd.service;

import com.br.dashProd.model.LinhaEntity;
import com.br.dashProd.model.LinhaRequestDTO;
import com.br.dashProd.model.LinhaResponseDTO;
import com.br.dashProd.respository.LinhaRepository;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LinhaService {
    private final LinhaRepository linhaRepository;

    public LinhaService(LinhaRepository linhaRepository) {
        this.linhaRepository = linhaRepository;
    }

    @Cacheable(cacheNames = "linhas")
    public Page<LinhaResponseDTO> listLinhas(Pageable pageable) {
        Page<LinhaEntity> linhas = linhaRepository.findAll(pageable);
        return  linhas.map(LinhaResponseDTO::fromEntity);
    }

    @CacheEvict(cacheNames = "linhas")
    public LinhaEntity saveLinhas(LinhaRequestDTO linhaRequestDTO) {
        LinhaEntity newLine = new LinhaEntity(
                linhaRequestDTO.conteudo(),
                linhaRequestDTO.materia(),
                linhaRequestDTO.pomodoros(),
                linhaRequestDTO.date()
        );
        return linhaRepository.save(newLine);
    }

    @Cacheable(cacheNames = "linha")
    public LinhaResponseDTO listLinha(Long id) {
        Optional<LinhaEntity> linha = linhaRepository.findById(id);
        return linha.map(LinhaResponseDTO::fromEntity).orElseThrow(NoSuchElementException::new);

    }
}

package com.br.dashProd.service;

import com.br.dashProd.mapper.StudySessionMapper;
import com.br.dashProd.model.LinhaEntity;
import com.br.dashProd.dtos.SessionStudyResponseDTO;
import com.br.dashProd.model.MateriaEntity;
import com.br.dashProd.respository.LinhaRepository;
import com.br.dashProd.respository.MateriaRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LinhaService {

    private final LinhaRepository linhaRepository;
    private final StudySessionMapper mapper;
    private final MateriaRepository materiaRepository;

    public LinhaService(LinhaRepository linhaRepository, StudySessionMapper mapper, MateriaRepository materia) {
        this.linhaRepository = linhaRepository;
        this.mapper = mapper;
        this.materiaRepository = materia;
    }

    @Cacheable(cacheNames = "linhas")
    public Page<SessionStudyResponseDTO> listLinhas(Pageable pageable) {
        Page<LinhaEntity> linhas = linhaRepository.findAll(pageable);
        return  linhas.map(mapper::toDTO);
    }

    @CacheEvict(cacheNames = "linhas")
    public LinhaEntity saveLinhas(SessionStudyResponseDTO SessionStudyResponseDTO) {

        Set<MateriaEntity> materias = SessionStudyResponseDTO.materia().stream()
                .map(materiaRepository::findByName)
                .map(Optional::orElseThrow)
                .collect(Collectors.toSet());

        LinhaEntity newLine = new LinhaEntity(
                SessionStudyResponseDTO.conteudo(),
                materias,
                SessionStudyResponseDTO.pomodoros(),
                SessionStudyResponseDTO.date()
        );
        return linhaRepository.save(newLine);
    }

    @Cacheable(cacheNames = "linha")
    public SessionStudyResponseDTO listLinha(Long id) {
        Optional<LinhaEntity> linha = linhaRepository.findById(id);
        return linha.map(mapper::toDTO).orElseThrow(NoSuchElementException::new);

    }
}

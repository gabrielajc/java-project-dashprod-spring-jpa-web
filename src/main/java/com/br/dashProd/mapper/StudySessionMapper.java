package com.br.dashProd.mapper;

import com.br.dashProd.dtos.SessionStudyResponseDTO;
import com.br.dashProd.model.LinhaEntity;
import com.br.dashProd.model.MateriaEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StudySessionMapper {

    public SessionStudyResponseDTO toDTO(LinhaEntity entity){

        Set<String> materia = entity.getMateria().stream()
                .map(MateriaEntity::getName)
                .collect(Collectors.toSet());

          SessionStudyResponseDTO session = new SessionStudyResponseDTO(
                entity.getId(),
                entity.getConteudo(),
                materia,
                entity.getPomodoros(),
                  entity.getDate());

        return session;
    }
}

package com.br.dashProd.service;

import com.br.dashProd.model.LinhaEntity;
import com.br.dashProd.model.LinhaRequestDTO;
import com.br.dashProd.respository.LinhaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinhaService {
    private final LinhaRepository linhaRepository;

    public LinhaService(LinhaRepository linhaRepository) {
        this.linhaRepository = linhaRepository;

    }

    public List<LinhaEntity> listLinhas() {
        return linhaRepository.findAll();

    }


    public LinhaEntity saveLinhas(LinhaRequestDTO linhaRequestDTO) {
        return linhaRepository.save();
    }
}

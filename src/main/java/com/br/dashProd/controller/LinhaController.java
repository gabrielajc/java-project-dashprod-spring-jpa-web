package com.br.dashProd.controller;

import com.br.dashProd.model.LinhaEntity;
import com.br.dashProd.model.LinhaRequestDTO;
import com.br.dashProd.model.LinhaResponseDTO;
import com.br.dashProd.service.LinhaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("dashProd/v1/")

public class LinhaController {

    private final LinhaService linhaService;

    @GetMapping("/linhas/{id}")
    public ResponseEntity getLinha(@PathVariable Long id){
        LinhaResponseDTO linha = linhaService.listLinha(id);
        return ResponseEntity.status(HttpStatus.OK).body(linha);
    }

    @GetMapping("/linhas")
    public ResponseEntity getLinhas(Pageable pageable){
        Page<LinhaResponseDTO> linhaResponseDTO = linhaService.listLinhas(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(linhaResponseDTO);
    }

    @Transactional
    @PostMapping("/linhas")
    public ResponseEntity salvarLinha(@RequestBody @Valid LinhaRequestDTO linhaRequestDTO){
        LinhaEntity response = linhaService.saveLinhas(linhaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Void> handleNoSuchElementException(){
        return ResponseEntity.notFound().build();
    }

    public LinhaController(LinhaService linhaService) {
        this.linhaService = linhaService;
    }
}

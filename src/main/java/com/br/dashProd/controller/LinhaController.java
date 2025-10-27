package com.br.dashProd.controller;

import com.br.dashProd.model.LinhaEntity;
import com.br.dashProd.model.LinhaRequestDTO;
import com.br.dashProd.model.LinhaResponseDTO;
import com.br.dashProd.service.LinhaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dashProd/v1/")

public class LinhaController {

    private final LinhaService linhaService;

    @GetMapping("/linhas")
    public ResponseEntity getLinhas(){
        List<LinhaResponseDTO> linhaResponseDTO = linhaService.listLinhas();
        return ResponseEntity.status(HttpStatus.OK).body(linhaResponseDTO);
    }

    @PostMapping("/linhas")
    public ResponseEntity salvarLinha(@RequestBody @Valid LinhaRequestDTO linhaRequestDTO){
        LinhaEntity response = linhaService.saveLinhas(linhaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public LinhaController(LinhaService linhaService) {
        this.linhaService = linhaService;
    }
}

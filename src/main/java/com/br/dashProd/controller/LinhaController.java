package com.br.dashProd.controller;

import com.br.dashProd.model.LinhaEntity;
import com.br.dashProd.model.LinhaRequestDTO;
import com.br.dashProd.service.LinhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "linha")

public class LinhaController {

    private final LinhaService linhaService;

    @GetMapping(path = "/linhas")
    public List<LinhaEntity> getLinhas(){
        return linhaService.listLinhas();
    }

    @PostMapping(path = "/linhas")
    public ResponseEntity salvarLinha(@RequestBody @Valid LinhaRequestDTO linhaRequestDTO){
        return linhaService.saveLinhas(linhaRequestDTO);
    }

    public LinhaController(LinhaService linhaService) {
        this.linhaService = linhaService;
    }
}

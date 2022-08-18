package com.api.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.models.Movimentacao;
import com.api.api.repositories.MovimentacaoRepository;

import antlr.collections.List;

@RestController
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @PostMapping
    public Optional<Movimentacao> novaMovimentacao() {
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoRepository.findAll());
    }

    

}
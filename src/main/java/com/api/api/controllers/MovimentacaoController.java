package com.api.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.models.Movimentacao;
import com.api.api.services.MovimentacaoService;


@RestController
@RequestMapping("movimentacao")
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoService movimentacaoService;
  
    @GetMapping
    public ResponseEntity<List<Movimentacao>> allMovimentacao() {
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> oneMovimentacao(@PathVariable(value = "id") Long id) {
        Optional<Movimentacao> movimentacaoOptional = movimentacaoService.findById(id);
        if (!movimentacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não encontrado na base de dados.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> saveMovimentacao(@RequestBody Movimentacao movimentacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoService.save(movimentacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMovimentacao(@RequestBody Movimentacao movimentacao, @PathVariable(value = "id") Long id) {
        Optional<Movimentacao> movimentacaoOptional = movimentacaoService.findById(id);
        if (!movimentacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não encontrado na base de dados.");
        }

        BeanUtils.copyProperties(movimentacaoOptional, movimentacao);
        movimentacao.setId(id);
       
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoService.save(movimentacao));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovimentacao(@PathVariable(value = "id") Long id) {
        Optional<Movimentacao> movimentacaoOptional = movimentacaoService.findById(id);
        if (!movimentacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não encontrado na base de dados.");
        }
        movimentacaoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Registro apagado da base de dados.");
    }

}
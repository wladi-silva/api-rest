package com.api.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.api.models.Movimentacao;
import com.api.api.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {
    
    @Autowired
    public MovimentacaoRepository movimentacaoRepository;

    @Transactional
    public Movimentacao save(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    public Optional<Movimentacao> findById(Long id) {
        return movimentacaoRepository.findById(id);
    }

}
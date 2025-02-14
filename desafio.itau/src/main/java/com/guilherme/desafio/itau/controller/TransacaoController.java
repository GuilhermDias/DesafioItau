package com.guilherme.desafio.itau.controller;

import com.guilherme.desafio.itau.domain.transacao.RequestTransacao;
import com.guilherme.desafio.itau.domain.transacao.Transacao;
import com.guilherme.desafio.itau.domain.transacao.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transacao> realizaTransacao(@RequestBody RequestTransacao dto){
        Transacao transacao = service.validaTransacao(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(transacao);
    }
}

package com.guilherme.desafio.itau.controller;

import com.guilherme.desafio.itau.domain.transacao.RequestTransacao;
import com.guilherme.desafio.itau.domain.transacao.Transacao;
import com.guilherme.desafio.itau.domain.transacao.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transacao> receberTransacoes(@RequestBody RequestTransacao dto){
        service.validaTransacao(dto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTransacoes(){
        return ResponseEntity.ok(service.listarTransacoes());
    }

    @DeleteMapping
    public ResponseEntity<Void> limparTransacoes(){
        service.limparTransacoes();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

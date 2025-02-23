package com.guilherme.desafio.itau.controller;

import com.guilherme.desafio.itau.domain.estatisticas.RequestEstatisticas;
import com.guilherme.desafio.itau.domain.transacao.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/estatistica", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstatisticaController {

    private final TransacaoService service;

    @GetMapping
    public ResponseEntity<RequestEstatisticas> buscaEstatisticas(){
        OffsetDateTime ultimo60Seg = OffsetDateTime.now().minusSeconds(60);

        RequestEstatisticas estatisticas = service.solicitaEstatistica(ultimo60Seg);

        return ResponseEntity.ok(estatisticas);
    }
}

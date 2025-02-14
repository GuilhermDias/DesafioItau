package com.guilherme.desafio.itau.domain.transacao;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transacao {

    @Positive
    private double valor;
    private OffsetDateTime dataHora;

}

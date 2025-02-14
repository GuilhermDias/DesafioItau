package com.guilherme.desafio.itau.domain.transacao;

import java.time.OffsetDateTime;

public record RequestTransacao(double valor, OffsetDateTime dataHora) {
}

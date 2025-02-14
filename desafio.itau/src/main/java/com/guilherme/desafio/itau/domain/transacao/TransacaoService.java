package com.guilherme.desafio.itau.domain.transacao;

import com.guilherme.desafio.itau.RegraDeNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final List<Transacao> transacoes = new ArrayList<>();

    public Transacao validaTransacao(RequestTransacao dto){

        validaValor(dto);
        validaDataHora(dto);

        Transacao novaTransacao = new Transacao(dto.valor(), dto.dataHora());
        transacoes.add(novaTransacao);

        return novaTransacao;
    }

    public void validaValor(RequestTransacao dto){

        if(dto.valor() < 0.0)
            throw new RegraDeNegocioException("O valor da transação precisa ser maior que 0");

    }

    public void validaDataHora(RequestTransacao dto){

        if(dto.dataHora().isAfter(OffsetDateTime.now()))
            throw new RegraDeNegocioException("A transação deve acontecer no passado");

    }
}

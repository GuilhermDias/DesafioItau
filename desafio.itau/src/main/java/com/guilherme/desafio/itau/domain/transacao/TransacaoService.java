package com.guilherme.desafio.itau.domain.transacao;

import com.guilherme.desafio.itau.RegraDeNegocioException;
import com.guilherme.desafio.itau.domain.estatisticas.RequestEstatisticas;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Transacao> listarTransacoes(){
        return new ArrayList<>(transacoes);
    }

    public void limparTransacoes(){
        transacoes.clear();
    }

    public RequestEstatisticas solicitaEstatistica(OffsetDateTime ulti60seg) {

        if(transacoes.isEmpty())
            throw new RegraDeNegocioException("Transações indisponiveis");

        List<Transacao> transacaosRecentes = transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(ulti60seg))
                .collect(Collectors.toList());

        DoubleSummaryStatistics estatisticas = transacaosRecentes.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        return new RequestEstatisticas(estatisticas.getCount(), estatisticas.getSum(),
                estatisticas.getAverage(), estatisticas.getMin(), estatisticas.getMax());

    }
}

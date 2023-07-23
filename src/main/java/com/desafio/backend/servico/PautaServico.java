package com.desafio.backend.servico;

import com.desafio.backend.entidade.Pauta;
import com.desafio.backend.entidade.StatusPauta;
import com.desafio.backend.excecao.PautaExcecao;
import com.desafio.backend.repositorio.PautaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@Transactional
public class PautaServico {

    private PautaRepositorio pautaRepositorio;

    @Autowired
    public PautaServico(PautaRepositorio pautaRepositorio) {
        this.pautaRepositorio = pautaRepositorio;
    }

    public Pauta cria(Pauta pauta) {

        pauta.setStatus(StatusPauta.AGUARDANDO_VOTACAO.get());

        return pautaRepositorio.save(pauta);
    }

    public Pauta abreSessao(Pauta pauta) {

        Optional<Pauta> pautaOptional = pautaRepositorio.findById(pauta.getId());

        if(pautaOptional.isEmpty()) throw new PautaExcecao(String.format("A pauta com o id: %d não foi encontrada", pauta.getId()));

        Pauta pautaBd = pautaOptional.get();

        if(pautaBd.getInicioSessao() != null) throw new PautaExcecao("A pauta já esta com a sessao aberta ou encerrada");

        pautaBd.setInicioSessao(ZonedDateTime.now());
        pautaBd.setDuracaoSessaoMinutos(pauta.getDuracaoSessaoMinutos());
        pautaBd.setStatus(StatusPauta.VOTACAO_ABERTA.get());

        return pautaRepositorio.save(pautaBd);
    }

}

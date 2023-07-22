package com.desafio.backend.servico;

import com.desafio.backend.entidade.Pauta;
import com.desafio.backend.entidade.StatusPauta;
import com.desafio.backend.repositorio.PautaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
}

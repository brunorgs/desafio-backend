package com.desafio.backend.controlador;

import com.desafio.backend.dto.PautaDto;
import com.desafio.backend.dto.PautaNomeDto;
import com.desafio.backend.servico.PautaServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pauta")
public class PautaControlador {

    private PautaServico pautaServico;

    @Autowired
    public PautaControlador(PautaServico pautaServico) {
        this.pautaServico = pautaServico;
    }

    @PostMapping
    public ResponseEntity<PautaDto> cria(@RequestBody @Valid PautaNomeDto pautaDto) {
        return new ResponseEntity<>(PautaDto.paraDto(pautaServico.cria(pautaDto.paraEntidade())), HttpStatus.CREATED);
    }
}

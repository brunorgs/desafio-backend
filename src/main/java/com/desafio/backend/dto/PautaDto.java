package com.desafio.backend.dto;

import com.desafio.backend.entidade.Pauta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PautaDto {

    private Long id;

    private String nome;

    private String status;

    private ZonedDateTime inicioSessao;

    private int duracaoSessaoMinutos;

    public PautaDto(Long id, String nome, String status, ZonedDateTime inicioSessao, int duracaoSessaoMinutos) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.inicioSessao = inicioSessao;
        this.duracaoSessaoMinutos = duracaoSessaoMinutos;
    }

    public static PautaDto paraDto(Pauta pauta) {
        return new PautaDto(pauta.getId(), pauta.getNome(), pauta.getStatus(), pauta.getInicioSessao(), pauta.getDuracaoSessaoMinutos());
    }
}

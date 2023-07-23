package com.desafio.backend.dto;

import com.desafio.backend.entidade.Pauta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PautaDto {

    private Long id;

    @NotBlank
    private String nome;

    private String status;

    private ZonedDateTime inicioSessao;

    @Min(1)
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

    public Pauta paraEntidade() {
        return new Pauta(this.id, this.nome, this.status, this.inicioSessao, this.duracaoSessaoMinutos);
    }
}

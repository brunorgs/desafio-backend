package com.desafio.backend.dto;

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
}

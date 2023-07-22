package com.desafio.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VotoDto {

    private Long idUsuario;

    private Long idPauta;

    private String valor;
}

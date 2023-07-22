package com.desafio.backend.dto;

import com.desafio.backend.entidade.Pauta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PautaNomeDto {

    @NotBlank
    private String nome;

    public Pauta paraEntidade() {
        return new Pauta(this.nome);
    }
}

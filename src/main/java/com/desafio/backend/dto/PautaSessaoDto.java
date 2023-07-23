package com.desafio.backend.dto;

import com.desafio.backend.entidade.Pauta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PautaSessaoDto {

    @NotNull
    private Long id;

    @Min(1)
    private int duracaoSessaoMinutos;

    public Pauta paraEntidade() {
        return new Pauta(this.id, this.duracaoSessaoMinutos);
    }
}

package com.desafio.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErroValidacaoDto {

    private List<String> mensagens;

    public ErroValidacaoDto(List<String> mensagem) {
        this.mensagens = mensagem;
    }
}

package com.desafio.backend.entidade;

public enum StatusPauta {

    AGUARDANDO_VOTACAO("Aguardando votação"),
    VOTACAO_ABERTA("Votação aberta"),
    APROVADA("Aprovada"),
    REPROVADA("Reprovada");

    private String status;
    StatusPauta(String status) {
        this.status = status;
    }

    public String get() {
        return this.status;
    }
}

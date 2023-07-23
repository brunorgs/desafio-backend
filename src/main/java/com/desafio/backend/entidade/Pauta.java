package com.desafio.backend.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Data
@NoArgsConstructor
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String status;

    private ZonedDateTime inicioSessao;

    private int duracaoSessaoMinutos = 1;

    public Pauta(String nome) {
        this.nome = nome;
    }

    public Pauta(Long id, String nome, String status, ZonedDateTime inicioSessao, int duracaoSessaoMinutos) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.inicioSessao = inicioSessao;
        this.duracaoSessaoMinutos = duracaoSessaoMinutos;
    }

    public Pauta(Long id, int duracaoSessaoMinutos) {
        this.id = id;
        this.duracaoSessaoMinutos = duracaoSessaoMinutos;
    }
}

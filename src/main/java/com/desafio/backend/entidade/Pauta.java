package com.desafio.backend.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Data
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
}

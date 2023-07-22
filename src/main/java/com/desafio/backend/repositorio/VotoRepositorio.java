package com.desafio.backend.repositorio;

import com.desafio.backend.entidade.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepositorio extends JpaRepository<Voto, Long> {
}

package com.desafio.backend.repositorio;

import com.desafio.backend.entidade.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepositorio extends JpaRepository<Pauta, Long> {
}

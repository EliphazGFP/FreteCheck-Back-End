package com.example.frete.domain.postagem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, String> {
    List<Postagem> findAllbyAtivoTrue();
}

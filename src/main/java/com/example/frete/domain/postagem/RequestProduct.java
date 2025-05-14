package com.example.frete.domain.postagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record RequestProduct(

        String id,
        @NotBlank
        String usuarioId,
        @NotNull
        String localOrigem,
        @NotNull
        String localDestino,
        @NotNull
        Date dataColeta,
        String descricao,
        String fotoCargaUrl
        ) {
}

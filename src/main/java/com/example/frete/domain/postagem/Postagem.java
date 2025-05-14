package com.example.frete.domain.postagem;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name="postagem")
@Entity(name="postagem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Postagem {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String usuario;

    private String descricao;

    private String localOrigem;

    private String localDestino;

    private Date dataColeta;

    private String fotoCargaURL;

    private Date dataCriacao;

    private boolean ativo;

    public Postagem(RequestProduct requestProduct){
        this.usuario = requestProduct.usuarioId();
        this.localOrigem = requestProduct.localOrigem();
        this.localDestino = requestProduct.localDestino();
        this.dataColeta = requestProduct.dataColeta();
        this.ativo = true;
    }
}

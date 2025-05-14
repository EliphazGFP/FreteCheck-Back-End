package com.example.frete.controllers;

import com.example.frete.domain.postagem.Postagem;
import com.example.frete.domain.postagem.PostagemRepository;
import com.example.frete.domain.postagem.RequestProduct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/postagem")
public class PostagemController {
    @Autowired
    private PostagemRepository postagemRepository;
    @GetMapping

    public ResponseEntity mostrarPostagem() {
        var allPostagems = postagemRepository.findAllbyAtivoTrue();
        return ResponseEntity.ok(allPostagems);
    }

    @PostMapping
    public ResponseEntity registrarPostagem(@RequestBody @Valid RequestProduct data){
        Postagem newPostagem = new Postagem(data);
        postagemRepository.save(newPostagem);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity atualizarPostagem(@RequestBody @Valid RequestProduct data){
        Optional<Postagem> optionalPostagem = postagemRepository.findById(data.id());
        if(optionalPostagem.isPresent()){
            Postagem postagem = optionalPostagem.get();
            postagem.setDescricao(data.descricao());
            postagem.setDataColeta(data.dataColeta());
            postagem.setLocalDestino(data.localDestino());
            postagem.setLocalOrigem(data.localOrigem());
        return ResponseEntity.ok(postagem);
        }else{
            throw new EntityNotFoundException();
        }
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPostagem(@PathVariable String id){
        Optional<Postagem> optionalPostagem = postagemRepository.findById(id);
        if (optionalPostagem.isPresent()) {
            Postagem postagem = optionalPostagem.get();
            postagem.setAtivo(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }

    }
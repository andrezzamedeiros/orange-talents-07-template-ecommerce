package br.com.mercadoLivre.controller;

import br.com.mercadoLivre.model.Categoria;
import br.com.mercadoLivre.model.Usuario;
import br.com.mercadoLivre.model.dto.request.NovaCategoriaRequest;
import br.com.mercadoLivre.model.dto.request.NovoUsuarioRequest;
import br.com.mercadoLivre.model.dto.response.NovaCategoriaResponse;
import br.com.mercadoLivre.model.dto.response.NovoUsuarioResponse;
import br.com.mercadoLivre.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<NovaCategoriaResponse> save(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest){
        Categoria categoria = novaCategoriaRequest.converter(manager);
        manager.persist(categoria);
        return ResponseEntity.ok(new NovaCategoriaResponse(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias(){
        return ResponseEntity.ok().body(categoriaRepository.findAll());
    }
}


package br.com.mercadoLivre.controller;

import br.com.mercadoLivre.model.Categoria;
import br.com.mercadoLivre.model.dto.request.CategoriaRequest;
import br.com.mercadoLivre.model.dto.response.CategoriaResponse;
import br.com.mercadoLivre.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CategoriaResponse> save(@RequestBody @Valid CategoriaRequest novaCategoriaRequest){
        Categoria categoria = novaCategoriaRequest.converter(manager);
        manager.persist(categoria);
        return ResponseEntity.ok(new CategoriaResponse(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias(){
        return ResponseEntity.ok().body(categoriaRepository.findAll());
    }
}


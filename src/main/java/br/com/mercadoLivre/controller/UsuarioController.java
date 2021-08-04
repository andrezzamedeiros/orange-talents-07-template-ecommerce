package br.com.mercadoLivre.controller;

import br.com.mercadoLivre.model.Usuario;
import br.com.mercadoLivre.model.dto.request.NovoUsuarioRequest;
import br.com.mercadoLivre.model.dto.response.NovoUsuarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<NovoUsuarioResponse> save(@RequestBody @Valid NovoUsuarioRequest usuarioRequest){
        Usuario usuario = usuarioRequest.converter();
        manager.persist(usuario);
        return ResponseEntity.ok(new NovoUsuarioResponse(usuario));
    }
}

package br.com.mercadoLivre.controller;

import br.com.mercadoLivre.model.User;
import br.com.mercadoLivre.model.dto.request.UsuarioRequest;
import br.com.mercadoLivre.model.dto.response.UsuarioResponse;
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
    public ResponseEntity<UsuarioResponse> save(@RequestBody @Valid UsuarioRequest usuarioRequest){
        User user = usuarioRequest.converter();
        manager.persist(user);
        return ResponseEntity.ok(new UsuarioResponse(user));
    }
}

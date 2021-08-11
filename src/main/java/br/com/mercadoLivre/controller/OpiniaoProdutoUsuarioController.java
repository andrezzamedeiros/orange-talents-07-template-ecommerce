package br.com.mercadoLivre.controller;

import br.com.mercadoLivre.model.OpiniaoUsuarioProduto;
import br.com.mercadoLivre.model.Produto;
import br.com.mercadoLivre.model.User;
import br.com.mercadoLivre.model.dto.request.OpiniaoUsuarioProdutoRequest;
import br.com.mercadoLivre.model.dto.request.ProdutoRequest;
import br.com.mercadoLivre.model.dto.response.OpiniaoUsuarioProdutoResponse;
import br.com.mercadoLivre.repositories.OpiniaoUsuarioProdutoRepository;
import br.com.mercadoLivre.repositories.ProdutoRepository;
import br.com.mercadoLivre.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class OpiniaoProdutoUsuarioController {

    @PersistenceContext
   private EntityManager manager;

    @PostMapping("/api/produtos/{produtoId}/opinioes")
    @Transactional
    public ResponseEntity<OpiniaoUsuarioProdutoResponse> criaOpiniao (
            @PathVariable Long produtoId ,
            @RequestBody @Valid OpiniaoUsuarioProdutoRequest request ,
            @AuthenticationPrincipal User user ) {

        Produto produto = manager.find(Produto.class , produtoId);
        if (!produto.pertenceAoUsuario(user)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        OpiniaoUsuarioProduto opiniao = request.converter(manager, user, produto);
        manager.persist(opiniao);
        return ResponseEntity.status(HttpStatus.CREATED).body(new OpiniaoUsuarioProdutoResponse(opiniao));
    }
}

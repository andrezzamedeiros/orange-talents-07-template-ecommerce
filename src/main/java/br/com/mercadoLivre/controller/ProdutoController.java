package br.com.mercadoLivre.controller;

import br.com.mercadoLivre.model.*;
import br.com.mercadoLivre.model.dto.request.CategoriaRequest;
import br.com.mercadoLivre.model.dto.request.ImagemProdutoRequest;
import br.com.mercadoLivre.model.dto.request.ProdutoRequest;
import br.com.mercadoLivre.model.dto.response.CategoriaResponse;
import br.com.mercadoLivre.model.dto.response.ImagemProdutoResponse;
import br.com.mercadoLivre.model.dto.response.ProdutoResponse;
import br.com.mercadoLivre.repositories.CaracteristicaProdutoRepository;
import br.com.mercadoLivre.repositories.CategoriaRepository;
import br.com.mercadoLivre.repositories.ProdutoRepository;
import br.com.mercadoLivre.repositories.UserRepository;
import br.com.mercadoLivre.uploader.Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CaracteristicaProdutoRepository caracteristicaProdutoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private Uploader uploader;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoResponse> save(@RequestBody @Valid ProdutoRequest produtoRequest, @AuthenticationPrincipal User user){
        Produto produto = produtoRequest.converter(categoriaRepository, user, userRepository);
        final Produto produtoPersistido = produtoRepository.save(produto);
        List<CaracteristicaProduto> caracteristicaProdutos = produtoRequest.getCaracteristicas().stream().map(caracteristicas -> caracteristicas.converter(produtoPersistido)).collect(Collectors.toList());

        return ResponseEntity.ok(new ProdutoResponse(caracteristicaProdutoRepository.saveAll(caracteristicaProdutos), produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos(){
        return ResponseEntity.ok().body(produtoRepository.findAll());
    }

    @PostMapping (consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE} )
    @RequestMapping("/{id}/imagens")
    @Transactional
    public ResponseEntity<String> uploadImagem (@PathVariable("id") Long id, @Valid ImagemProdutoRequest imagemProdutoRequest, @AuthenticationPrincipal User user){
        Produto produto = manager.find(Produto.class, id);
        if(!produto.pertenceAoUsuario(user)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        Set<String> links = uploader.envia(imagemProdutoRequest.getImagens());

        produto.associaImagens(links);
        manager.merge(produto);

        return ResponseEntity.ok(produto.toString());
    }
}

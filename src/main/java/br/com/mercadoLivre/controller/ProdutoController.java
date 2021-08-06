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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @RequestMapping("/imagens/{idProduto}")
    public ResponseEntity<List<String>> saveImage (@PathVariable Long id, @RequestBody @Valid List<ImagemProdutoRequest> listImagemProdutoRequest){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            listImagemProdutoRequest.forEach(imagemProduto -> manager.persist(imagemProduto.converter(produto.get())));
        }else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listImagemProdutoRequest.stream().map(x -> x.getUrlImagem()).collect(Collectors.toList()));
    }
}

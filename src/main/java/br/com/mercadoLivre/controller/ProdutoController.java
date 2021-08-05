package br.com.mercadoLivre.controller;

import br.com.mercadoLivre.model.CaracteristicaProduto;
import br.com.mercadoLivre.model.Categoria;
import br.com.mercadoLivre.model.Produto;
import br.com.mercadoLivre.model.dto.request.CategoriaRequest;
import br.com.mercadoLivre.model.dto.request.ProdutoRequest;
import br.com.mercadoLivre.model.dto.response.CategoriaResponse;
import br.com.mercadoLivre.model.dto.response.ProdutoResponse;
import br.com.mercadoLivre.repositories.CaracteristicaProdutoRepository;
import br.com.mercadoLivre.repositories.CategoriaRepository;
import br.com.mercadoLivre.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
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

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoResponse> save(@RequestBody @Valid ProdutoRequest produtoRequest){
        Produto produto = produtoRequest.converter(categoriaRepository);
        final Produto produtoPersistido = produtoRepository.save(produto);
        List<CaracteristicaProduto> caracteristicaProdutos = produtoRequest.getCaracteristicas().stream().map(caracteristicas -> caracteristicas.converter(produtoPersistido)).collect(Collectors.toList());

        return ResponseEntity.ok(new ProdutoResponse(caracteristicaProdutoRepository.saveAll(caracteristicaProdutos), produto));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias(){
        return ResponseEntity.ok().body(categoriaRepository.findAll());
    }
}

package br.com.mercadoLivre.controller;

import br.com.mercadoLivre.controller.Mailer.CarteiroManager;
import br.com.mercadoLivre.model.PerguntaUsuarioProduto;
import br.com.mercadoLivre.model.Produto;
import br.com.mercadoLivre.model.User;
import br.com.mercadoLivre.model.dto.request.PerguntaUsuarioProdutoRequest;
import br.com.mercadoLivre.model.dto.response.PerguntaUsuarioProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PerguntaUsuarioProdutoController {
    @PersistenceContext

    private EntityManager manager;

    @Autowired
    private CarteiroManager carteiroManager;


    @PostMapping( "/api/produtos/{produtoId}/perguntas" )
    @Transactional
    public ResponseEntity<PerguntaUsuarioProdutoResponse> createQuestion (
            @PathVariable Long produtoId ,
            @RequestBody @Valid PerguntaUsuarioProdutoRequest request ,
            @AuthenticationPrincipal User user ) {
        Produto produto = manager.find(Produto.class , produtoId);
        PerguntaUsuarioProduto pergunta = request.converter(produto, user);
        System.out.println(pergunta.toString());
        manager.persist(pergunta);

        carteiroManager.novaPergunta(pergunta);

        return ResponseEntity.status(HttpStatus.CREATED).body(new PerguntaUsuarioProdutoResponse(pergunta));
    }
}

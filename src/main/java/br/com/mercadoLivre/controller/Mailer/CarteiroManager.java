package br.com.mercadoLivre.controller.Mailer;

import br.com.mercadoLivre.model.PerguntaUsuarioProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Component
public class CarteiroManager {
    @Autowired
    private CarteiroFake carteiro;

    public void novaPergunta ( @NotNull @Valid PerguntaUsuarioProduto pergunta ) {
        var to = pergunta.getUsuario().getLogin();
        carteiro.envia("html" ,
                "question" ,
                "no-reply@mercadolivre.com.br" ,
                to
        );
    }
}


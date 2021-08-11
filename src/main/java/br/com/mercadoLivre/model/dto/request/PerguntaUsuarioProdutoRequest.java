package br.com.mercadoLivre.model.dto.request;

import br.com.mercadoLivre.model.PerguntaUsuarioProduto;
import br.com.mercadoLivre.model.Produto;
import br.com.mercadoLivre.model.User;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class PerguntaUsuarioProdutoRequest {

    @NotBlank
    private String titulo;
    private LocalDateTime instante = LocalDateTime.now();

    public PerguntaUsuarioProdutoRequest(@NotBlank String titulo) {
        this.titulo = titulo;
    }

    @Deprecated
    public PerguntaUsuarioProdutoRequest(){

    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public PerguntaUsuarioProduto converter (Produto produto , User usuario ) {
        Assert.notNull(produto , "produto não pode ser nulo");
        Assert.notNull(usuario , "usuario não pode ser nulo");

        return new PerguntaUsuarioProduto(titulo , usuario , produto);
    }

}

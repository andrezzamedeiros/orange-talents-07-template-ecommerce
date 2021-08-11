package br.com.mercadoLivre.model.dto.response;

import br.com.mercadoLivre.model.PerguntaUsuarioProduto;

import java.time.LocalDateTime;

public class PerguntaUsuarioProdutoResponse {

    private String titulo;
    private LocalDateTime instante;

    public PerguntaUsuarioProdutoResponse(PerguntaUsuarioProduto perguntaUsuarioProduto) {
        this.titulo = perguntaUsuarioProduto.getTitulo();
        this.instante = perguntaUsuarioProduto.getInstante();
    }


    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getInstante() {
        return instante;
    }
}

package br.com.mercadoLivre.model.dto.response;

import br.com.mercadoLivre.model.ImagemProduto;
import br.com.mercadoLivre.model.Produto;

import javax.persistence.ManyToOne;

public class ImagemProdutoResponse {

    private String urlImagem;

    public ImagemProdutoResponse(ImagemProduto imagemProduto) {
        this.urlImagem = imagemProduto.getUrlImagem();
    }
}

package br.com.mercadoLivre.model.dto.request;

import br.com.mercadoLivre.model.ImagemProduto;
import br.com.mercadoLivre.model.Produto;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ImagemProdutoRequest {

    @NotBlank @NotNull @URL
    private String urlImagem;

    public ImagemProdutoRequest(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public ImagemProduto converter(Produto produto){
        return new ImagemProduto(this.urlImagem, produto);
    }
}

package br.com.mercadoLivre.model;

import javax.persistence.*;

@Entity
public class ImagemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlImagem;

    @ManyToOne
    private Produto produto;

    public ImagemProduto() {
    }

    public ImagemProduto(String urlImagem, Produto produto) {
        this.urlImagem = urlImagem;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public Produto getProduto() {
        return produto;
    }
}

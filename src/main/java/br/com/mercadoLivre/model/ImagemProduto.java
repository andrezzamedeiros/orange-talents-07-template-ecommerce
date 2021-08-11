package br.com.mercadoLivre.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class ImagemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @URL
    @NotBlank
    private String urlImagem;

    @NotNull
    @Valid
    @ManyToOne
    private Produto produto;

    @Deprecated
    public ImagemProduto() {
    }

    public ImagemProduto(@URL String urlImagem, @NotNull @Valid Produto produto) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagemProduto that = (ImagemProduto) o;
        return Objects.equals(urlImagem, that.urlImagem) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urlImagem, produto);
    }

    @Override public String toString () {
        return "ImagemProduto{" +
                "id=" + id +
                ", link='" + urlImagem + '\'' +
                '}';
    }
}

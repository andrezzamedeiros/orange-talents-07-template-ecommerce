package br.com.mercadoLivre.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Nullable
    private Long idCategoriaMae;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoriaMae", referencedColumnName = "id")
    private Categoria categoriaMae;

    @Deprecated
    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
        this.idCategoriaMae = idCategoriaMae;
    }
    public Categoria(String nome, Long idCategoriaMae) {
        this.nome = nome;
        this.idCategoriaMae = idCategoriaMae;
    }

    public Categoria(Long id, String nome, @Nullable Long idCategoriaMae) {
        this.id = id;
        this.nome = nome;
        this.idCategoriaMae = idCategoriaMae;
        this.categoriaMae = this.getCategoriaMae();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdCategoriaMae() {
        return idCategoriaMae;
    }

    public Categoria getCategoriaMae() {
        return categoriaMae;
    }
    public void setCategoriaMae(Categoria categoriaMae) {
        this.categoriaMae = categoriaMae;
    }
}

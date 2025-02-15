package br.com.mercadoLivre.model.dto.request;

import br.com.mercadoLivre.model.Categoria;
import br.com.mercadoLivre.validations.annotations.UniqueValue;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import javax.persistence.*;

public class CategoriaRequest {

    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;
    @Nullable
    private Long idCategoriaMae;

    public CategoriaRequest() {
    }

    public CategoriaRequest(String nome, Long idCategoriaMae) {
        this.nome = nome;
        this.idCategoriaMae = idCategoriaMae;
    }

    public String getNome() {
        return nome;
    }

    public Categoria converter(EntityManager manager){
        Categoria categoria = new Categoria(nome);
        if(idCategoriaMae != null ){
            Assert.notNull(idCategoriaMae, "Id da categoria mãe precisa ser válido");
            Categoria categoriaMae = manager.find(Categoria.class, idCategoriaMae);
            categoria.setCategoriaMae(categoriaMae);
        }
        return categoria;
    }
}


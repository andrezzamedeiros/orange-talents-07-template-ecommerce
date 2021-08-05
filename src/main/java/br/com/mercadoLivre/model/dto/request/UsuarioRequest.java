package br.com.mercadoLivre.model.dto.request;

import br.com.mercadoLivre.model.SenhaLimpa;
import br.com.mercadoLivre.model.User;
import br.com.mercadoLivre.validations.annotations.UniqueValue;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioRequest {

    @Email @NotBlank @UniqueValue(domainClass = User.class, fieldName = "login")
    private String login;
    @NotBlank @Length(min = 6)
    private String senha;

    public UsuarioRequest(@Email @NotBlank String login, @NotBlank @Length(min = 6) String senha) {
        Assert.isTrue(StringUtils.hasLength(login) , "login não pode ser em branco");
        Assert.isTrue(StringUtils.hasLength(senha), "senha não pode estar em branco");
        Assert.isTrue(senha.length() >= 6, "senha precisa de no mínimo 6 caracteres");
        this.login = login;
        this.senha = senha;
    }

    public User converter(){
        return new User(login, new SenhaLimpa(senha));
    }
}

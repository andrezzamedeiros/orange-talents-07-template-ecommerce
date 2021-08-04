package br.com.mercadoLivre.model.dto.request;

import br.com.mercadoLivre.model.Usuario;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoUsuarioRequest {

    @Email @NotBlank
    private String email;
    @NotBlank @Length(min = 6)
    private String senha;

    public NovoUsuarioRequest(@Email @NotBlank String email,@NotBlank @Length(min = 6) String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario converter(){
        return new Usuario(email, new BCryptPasswordEncoder().encode(senha));
    }
}

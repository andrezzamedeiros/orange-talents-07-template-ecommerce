package br.com.mercadoLivre.model.dto.response;

import br.com.mercadoLivre.model.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

public class NovoUsuarioResponse {

    private String email;
    private LocalDateTime dataCadastro;

    public NovoUsuarioResponse() {
    }

    public NovoUsuarioResponse(Usuario usuario) {
        this.email = usuario.getEmail();
        this.dataCadastro = usuario.getDataCadastro();
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}

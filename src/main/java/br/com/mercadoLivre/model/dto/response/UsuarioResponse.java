package br.com.mercadoLivre.model.dto.response;

import br.com.mercadoLivre.model.User;

import java.time.LocalDateTime;

public class UsuarioResponse {

    private String email;
    private LocalDateTime dataCadastro;

    public UsuarioResponse() {
    }

    public UsuarioResponse(User user) {
        this.email = user.getLogin();
        this.dataCadastro = user.getDataCadastro();
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}

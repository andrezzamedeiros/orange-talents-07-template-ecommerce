package br.com.mercadoLivre.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;

public class SenhaLimpa {

    private String passwordPlainText;

    public SenhaLimpa ( String passwordPlainText ) {
        this.passwordPlainText = passwordPlainText;
    }

    public String getPasswordPlainText () {
        return passwordPlainText;
    }
}

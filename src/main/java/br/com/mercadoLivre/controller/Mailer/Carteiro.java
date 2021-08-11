package br.com.mercadoLivre.controller.Mailer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public interface Carteiro {
     void envia(
            @NotBlank String body,
            @NotBlank String subject,
            @NotBlank @Email String from,
            @NotBlank @Email String to);
}


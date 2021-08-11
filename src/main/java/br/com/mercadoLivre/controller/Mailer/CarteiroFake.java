package br.com.mercadoLivre.controller.Mailer;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Component
public class CarteiroFake implements Carteiro {
    @Override
    public void envia( @NotBlank String body ,
                       @NotBlank String subject ,
                       @NotBlank @Email String from ,
                       @NotBlank @Email String to ) {
        System.out.println(body);
        System.out.println(subject);
        System.out.println(from);
        System.out.println(to);
    }
}

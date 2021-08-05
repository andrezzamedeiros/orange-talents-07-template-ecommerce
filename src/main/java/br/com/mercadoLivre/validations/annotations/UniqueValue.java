package br.com.mercadoLivre.validations.annotations;

import br.com.mercadoLivre.validations.UniqueValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ElementType.FIELD})
public @interface UniqueValue {

    String message()default "{br.com.zup.desafio.casadocodigo.beanvalidation.uniquevalue}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default{ };

    String fieldName();

    Class<?> domainClass();
}
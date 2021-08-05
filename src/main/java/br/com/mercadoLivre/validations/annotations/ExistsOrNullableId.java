package br.com.mercadoLivre.validations.annotations;

import br.com.mercadoLivre.validations.ExistsOrNullableIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ExistsOrNullableIdValidator.class})
@Target({ElementType.FIELD})
public @interface ExistsOrNullableId {

    String message()default "{br.com.zup.desafio.casadocodigo.beanvalidation.uniquevalue}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default{ };

    String fieldName();

    Class<?> domainClass();

}

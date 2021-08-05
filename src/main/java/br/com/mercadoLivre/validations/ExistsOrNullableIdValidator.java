package br.com.mercadoLivre.validations;

import br.com.mercadoLivre.validations.annotations.ExistsOrNullableId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsOrNullableIdValidator implements ConstraintValidator<ExistsOrNullableId, Object> {

    @PersistenceContext
    EntityManager manager;

    private String domainAtributte;
    private Class<?> klass;


    @Override
    public void initialize(ExistsOrNullableId params) {
        domainAtributte = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        try{
            if(domainAtributte == null){
                return true;
            }
            Query query = manager.createQuery("SELECT 1 FROM " + klass.getName() + " where " +domainAtributte + " =:value");
            query.setParameter("value", value);
            List resultList = query.getResultList();
            return !resultList.isEmpty();
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
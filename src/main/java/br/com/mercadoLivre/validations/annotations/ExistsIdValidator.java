package br.com.mercadoLivre.validations.annotations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

    @PersistenceContext
    EntityManager manager;

    private String domainAtributte;
    private Class<?> klass;


    @Override
    public void initialize(ExistsId params) {
        domainAtributte = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        try{
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
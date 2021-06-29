package br.com.zupedu.casadocodigo.controller.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidaCampoDuplicadoValidator implements ConstraintValidator<ValidaCampoDuplicado, Object> {

    @PersistenceContext
    private EntityManager manager;

    private String campo;
    private Class<?> aClass;

    @Override
    public void initialize(ValidaCampoDuplicado dadosDaClasse) {
        this.campo = dadosDaClasse.atributo();
        this.aClass = dadosDaClasse.aClass();
    }

    @Override
    public boolean isValid(Object valorRecebido, ConstraintValidatorContext constraintValidatorContext) {

        Query resultado = manager.createQuery(
                "SELECT c FROM " + aClass.getName() +" c where c." + campo + " =: valor");

        resultado.setParameter("valor", valorRecebido);

        if(resultado.getResultList().isEmpty()){
            return true;
        }else{
            return false;
        }

    }


}

/*
* [CTRL] + I -> implementar os metodos obrigatórios
* */

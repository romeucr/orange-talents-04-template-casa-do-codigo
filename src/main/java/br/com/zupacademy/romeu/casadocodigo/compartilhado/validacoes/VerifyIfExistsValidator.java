package br.com.zupacademy.romeu.casadocodigo.compartilhado.validacoes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VerifyIfExistsValidator implements ConstraintValidator<VerifyIfExists, Object> {

  private String campo;
  private Class<?> tabela;

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public void initialize(VerifyIfExists constraintAnnotation) {
    this.campo = constraintAnnotation.campo();
    this.tabela = constraintAnnotation.tabela();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {

    Boolean valorJaExiste = entityManager
          .createQuery("SELECT COUNT(t) < 1 FROM " + tabela.getName() + " t WHERE "
          + campo + " = :pValor", Boolean.class)
          .setParameter("pValor", value)
          .getSingleResult();

    return !valorJaExiste;
  }

}

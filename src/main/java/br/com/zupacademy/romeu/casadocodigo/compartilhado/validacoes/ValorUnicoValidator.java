package br.com.zupacademy.romeu.casadocodigo.compartilhado.validacoes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, Object> {

  private String campo;
  private Class<?> tabela;
  private boolean removeStrings;

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public void initialize(ValorUnico constraintAnnotation) {
    this.campo = constraintAnnotation.campo();
    this.tabela = constraintAnnotation.tabela();
    this.removeStrings = constraintAnnotation.removeStrings();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {

    if (removeStrings) {
      value = value.toString().replaceAll("[^0-9]", "");
    }

    Boolean valorJaExiste = entityManager
          .createQuery("SELECT COUNT(t) < 1 FROM " + tabela.getName() + " t WHERE "
          + campo + " = :pValor", Boolean.class)
          .setParameter("pValor", value)
          .getSingleResult();

    return valorJaExiste;
  }

}

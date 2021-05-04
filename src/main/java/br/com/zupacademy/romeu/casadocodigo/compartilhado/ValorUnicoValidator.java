package br.com.zupacademy.romeu.casadocodigo.compartilhado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, Object> {

  private String campo;
  private Class<?> tabela;

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public void initialize(ValorUnico constraintAnnotation) {
    this.campo = constraintAnnotation.campo();
    this.tabela = constraintAnnotation.tabela();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {

    if (campo.equalsIgnoreCase("isbn")) {
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

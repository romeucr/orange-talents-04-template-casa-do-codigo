package br.com.zupacademy.romeu.casadocodigo.compartilhado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class VerificaUnicidadeNoBancoValidator implements ConstraintValidator<VerificaUnicidadeNoBanco, Object> {

  private String campo;
  private Class<?> tabela;

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public void initialize(VerificaUnicidadeNoBanco constraintAnnotation) {
    this.campo = constraintAnnotation.campo();
    this.tabela = constraintAnnotation.tabela();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    List<?> listaResultados = entityManager.createQuery("SELECT t FROM "
            + tabela.getName()
            + " t WHERE "
            + campo
            + " = :valor")
            .setParameter("valor", value)
            .getResultList();

    return listaResultados.isEmpty();
  }

}

package br.com.zupacademy.romeu.casadocodigo.compartilhado.validacoes;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR)
@ReportAsSingleViolation // O erro de cada validação específica é ignorado
@Constraint(validatedBy = { }) // we don't need a validator :-)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface CPFOuCNPJ {

  String message() default "CPF ou CNPJ inválido";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

}

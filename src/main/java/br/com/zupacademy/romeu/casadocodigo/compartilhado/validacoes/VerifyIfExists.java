package br.com.zupacademy.romeu.casadocodigo.compartilhado.validacoes;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = VerifyIfExistsValidator.class)
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface VerifyIfExists {
  String message() default "O valor informado não está cadastrado no banco de dados";

  String campo();
  Class<?> tabela();

  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}

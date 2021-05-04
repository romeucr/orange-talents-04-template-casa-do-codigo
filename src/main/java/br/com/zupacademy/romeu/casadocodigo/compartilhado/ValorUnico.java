package br.com.zupacademy.romeu.casadocodigo.compartilhado;

import com.fasterxml.jackson.databind.node.BooleanNode;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ValorUnicoValidator.class)
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface ValorUnico {
  String message() default "O valor informado já está cadastrado no banco de dados";

  String campo();
  Class<?> tabela();

  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}

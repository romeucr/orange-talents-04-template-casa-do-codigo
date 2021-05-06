package br.com.zupacademy.romeu.casadocodigo.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = VerifyEstadoPaisValidator.class)
@Target({ METHOD, CONSTRUCTOR, LOCAL_VARIABLE })
@Retention(RUNTIME)
public @interface VerifyEstadoPais {
  String message() default "Estado já está cadastrado neste País.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}

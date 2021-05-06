package br.com.zupacademy.romeu.casadocodigo.compartilhado;

import br.com.zupacademy.romeu.casadocodigo.estado.Estado;
import br.com.zupacademy.romeu.casadocodigo.estado.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class VerifyEstadoPaisValidator implements ConstraintValidator<VerifyEstadoPais, Estado> {

  @Autowired
  EstadoRepository estadoRepository;

  @Override
  public void initialize(VerifyEstadoPais constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(Estado estado, ConstraintValidatorContext context) {
    String estadoNome = estado.getNome();
    Long paisId = estado.getPais().getId();

    Optional<Estado> optEstado = estadoRepository.findByNomeAndPaisId(estadoNome, paisId);

    return optEstado.isEmpty();
  }
}

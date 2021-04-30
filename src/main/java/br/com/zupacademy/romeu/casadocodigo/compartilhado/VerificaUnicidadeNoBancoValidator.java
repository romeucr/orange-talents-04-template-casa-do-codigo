package br.com.zupacademy.romeu.casadocodigo.compartilhado;

import br.com.zupacademy.romeu.casadocodigo.autor.Autor;
import br.com.zupacademy.romeu.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.romeu.casadocodigo.categoria.Categoria;
import br.com.zupacademy.romeu.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class VerificaUnicidadeNoBancoValidator implements ConstraintValidator<VerificaUnicidadeNoBanco, String> {

  @Autowired
  private AutorRepository autorRepository;

  @Autowired
  private CategoriaRepository categoriaRepository;

  private String autorOuCategoria;

  @Override
  public void initialize(VerificaUnicidadeNoBanco constraintAnnotation) {
    this.autorOuCategoria = constraintAnnotation.autorOuCategoria();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    if (autorOuCategoria.equalsIgnoreCase("autor")) {
      Optional<Autor> optAutor = autorRepository.findByEmail(value);
      return optAutor.isEmpty();
    } else {
      Optional<Categoria> optCategoria = categoriaRepository.findByNome(value);
      return optCategoria.isEmpty();
    }
  }

}

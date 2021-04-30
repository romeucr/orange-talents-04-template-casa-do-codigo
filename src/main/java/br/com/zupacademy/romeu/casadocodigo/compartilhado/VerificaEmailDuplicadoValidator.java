package br.com.zupacademy.romeu.casadocodigo.compartilhado;

import br.com.zupacademy.romeu.casadocodigo.autor.Autor;
import br.com.zupacademy.romeu.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.romeu.casadocodigo.autor.NovoAutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class VerificaEmailDuplicadoValidator implements Validator {

  @Autowired
  private AutorRepository autorRepository;

  @Override
  public boolean supports(Class<?> aClass) {
    return NovoAutorRequest.class.isAssignableFrom(aClass);
    // qual é o tipo de parâmetro onde a verificação será realizada.
    // verifica se a classe que está chegando pelo parâmetro é filha o a própria NovoAutorRequest
  }

  @Override
  public void validate(Object o, Errors errors) {
    // verifica se já houve algum erro anterior identificado pelos validadores nativos do spring.
    // se já há erros, não executa a validação personalizada.
    if (errors.hasErrors()) {
      return;
    }

    NovoAutorRequest request = (NovoAutorRequest) o;
    Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());

    if (possivelAutor.isPresent()) {
      // campo, código de erro, mensagem de erro
      errors.rejectValue("email", "AutorCadastrado", "{AutorCadastrado.email}");
    }

  }
}

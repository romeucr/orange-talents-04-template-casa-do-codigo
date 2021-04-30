package br.com.zupacademy.romeu.casadocodigo.compartilhado;


import br.com.zupacademy.romeu.casadocodigo.autor.NovoAutorRequest;
import br.com.zupacademy.romeu.casadocodigo.categoria.Categoria;
import br.com.zupacademy.romeu.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.romeu.casadocodigo.categoria.NovaCategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class VerificaCategoriaDuplicadaValidator implements Validator {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Override
  public boolean supports(Class<?> aClass) {
    return NovaCategoriaRequest.class.isAssignableFrom(aClass);
  }

  @Override
  public void validate(Object o, Errors errors) {
    if (errors.hasErrors()) {
      return;
    }

    NovaCategoriaRequest request = (NovaCategoriaRequest) o;
    Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(request.getNome());

    if (possivelCategoria.isPresent()) {
      // campo, código de erro, mensagem de erro
      errors.rejectValue("nome", "CategoriaCadastrada", "{CategoriaCadastrada.nome}");
    }

  }
}

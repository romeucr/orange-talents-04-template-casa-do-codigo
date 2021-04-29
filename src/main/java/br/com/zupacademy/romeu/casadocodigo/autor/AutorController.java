package br.com.zupacademy.romeu.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

  @Autowired
  AutorRepository autorRepository;

  @PostMapping
  @Transactional
  public void cadastraAutor(@RequestBody @Valid NovoAutorRequest novoAutorRequest) {
    Autor autor = novoAutorRequest.toModel();
    autorRepository.save(autor);
  }
}

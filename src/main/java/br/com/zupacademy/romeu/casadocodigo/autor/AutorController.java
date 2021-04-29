package br.com.zupacademy.romeu.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

  @Autowired
  AutorRepository autorRepository;

  @PostMapping
  @Transactional
  public ResponseEntity<?> cadastraAutor(@RequestBody @Valid NovoAutorRequest novoAutorRequest) {

    Optional<Autor> optAutor = autorRepository.findByEmail(novoAutorRequest.getEmail());
    if (optAutor.isPresent()) {
      return ResponseEntity.badRequest().body("E-mail já cadastrado");
    }

    Autor autor = novoAutorRequest.toModel();
    autorRepository.save(autor);
    return ResponseEntity.ok().build();
  }

}

package br.com.zupacademy.romeu.casadocodigo.autor;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.VerificaEmailDuplicadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

  @Autowired
  AutorRepository autorRepository;

  @Autowired
  private VerificaEmailDuplicadoValidator verificaEmailDuplicadoValidator;

  @InitBinder
  public void init(WebDataBinder binder) {
    // método executado sempre que o controlador (algum dos métodos) é chamado
    binder.addValidators(verificaEmailDuplicadoValidator);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<?> cadastraAutor(@RequestBody @Valid NovoAutorRequest novoAutorRequest) {

    Optional<Autor> optAutor = autorRepository.findByEmail(novoAutorRequest.getEmail());

    Autor autor = novoAutorRequest.toModel();
    autorRepository.save(autor);
    return ResponseEntity.ok().build();
  }

}

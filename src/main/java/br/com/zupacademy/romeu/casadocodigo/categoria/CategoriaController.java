package br.com.zupacademy.romeu.casadocodigo.categoria;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.VerificaCategoriaDuplicadaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Autowired
  private VerificaCategoriaDuplicadaValidator verificaCategoriaDuplicadaValidator;

  @InitBinder
  public void init(WebDataBinder binder) {
    binder.addValidators(verificaCategoriaDuplicadaValidator);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<?> cadastraCategoria(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest) {
    Categoria categoria = novaCategoriaRequest.toModel();
    categoriaRepository.save(categoria);
    return ResponseEntity.ok().build();
  }
}

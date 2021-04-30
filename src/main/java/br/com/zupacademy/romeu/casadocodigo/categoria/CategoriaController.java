package br.com.zupacademy.romeu.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @PostMapping
  @Transactional
  public ResponseEntity<?> cadastraCategoria(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest) {
    Categoria categoria = novaCategoriaRequest.toModel();
    categoriaRepository.save(categoria);
    return ResponseEntity.ok().build();
  }
}

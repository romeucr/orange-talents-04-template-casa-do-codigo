package br.com.zupacademy.romeu.casadocodigo.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

  @Autowired
  private PaisRepository paisRepository;

  @PostMapping
  @Transactional
  public ResponseEntity<?> cadastraPais(@RequestBody @Valid NovoPaisRequest novoPaisRequest) {
    Pais pais = novoPaisRequest.toModel();
    paisRepository.save(pais);
    return ResponseEntity.ok().build();
  }
}

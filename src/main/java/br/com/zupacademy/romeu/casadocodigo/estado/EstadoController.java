package br.com.zupacademy.romeu.casadocodigo.estado;

import br.com.zupacademy.romeu.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

  @Autowired
  private EstadoRepository estadoRepository;

  @Autowired
  private PaisRepository paisRepository;

  @PostMapping
  @Transactional
  public ResponseEntity<?> cadastraEstado(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest) {
    String estadoNome = novoEstadoRequest.getNome();
    Long paisId = novoEstadoRequest.getPaisId();

    if (estadoRepository.findByNomeAndPaisId(estadoNome, paisId).isPresent()) {
      return ResponseEntity.badRequest().body("Já existe cadastrado este Estado para o mesmo País ") ;
    }

    Estado estado = novoEstadoRequest.toModel(paisRepository);
    estadoRepository.save(estado);
    return ResponseEntity.ok().build();
  }
}

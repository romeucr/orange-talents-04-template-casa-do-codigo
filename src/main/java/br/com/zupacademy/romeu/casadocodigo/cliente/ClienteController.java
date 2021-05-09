package br.com.zupacademy.romeu.casadocodigo.cliente;

import br.com.zupacademy.romeu.casadocodigo.estado.EstadoRepository;
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
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  private PaisRepository paisRepository;

  @Autowired
  private EstadoRepository estadoRepository;

  @PostMapping
  @Transactional
  public ResponseEntity<NovoClienteResponse> novoCliente(@RequestBody @Valid NovoClienteRequest novoClienteRequest) {
    Cliente cliente = novoClienteRequest.toModel(paisRepository, estadoRepository);
    clienteRepository.save(cliente);
    return ResponseEntity.ok(new NovoClienteResponse(cliente));
  }
}

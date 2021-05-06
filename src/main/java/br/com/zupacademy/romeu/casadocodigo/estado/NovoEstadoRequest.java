package br.com.zupacademy.romeu.casadocodigo.estado;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.VerifyEstadoPais;
import br.com.zupacademy.romeu.casadocodigo.pais.Pais;
import br.com.zupacademy.romeu.casadocodigo.pais.PaisRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class NovoEstadoRequest {

  @NotBlank
  private String nome;

  @NotNull
  private Long paisId;

  @Deprecated
  public NovoEstadoRequest(){}

  public Estado toModel(PaisRepository paisRepository) {
    Optional<Pais> optPais = paisRepository.findById(this.getPaisId());
    return new Estado(this.nome, optPais.get());
  }

  public String getNome() {
    return nome;
  }

  public Long getPaisId() {
    return paisId;
  }
}

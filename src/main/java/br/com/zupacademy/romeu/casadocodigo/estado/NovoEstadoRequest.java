package br.com.zupacademy.romeu.casadocodigo.estado;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.validacoes.VerifyIfExists;
import br.com.zupacademy.romeu.casadocodigo.pais.Pais;
import br.com.zupacademy.romeu.casadocodigo.pais.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class NovoEstadoRequest {

  @NotBlank
  private String nome;

  @NotNull
  @VerifyIfExists(campo = "id", tabela = Pais.class)
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

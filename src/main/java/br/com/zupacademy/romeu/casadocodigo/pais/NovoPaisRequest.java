package br.com.zupacademy.romeu.casadocodigo.pais;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.ValorUnico;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

  @NotBlank
  @ValorUnico(campo = "nome", tabela = Pais.class)
  private String nome;

  public Pais toModel() {
    return new Pais(this.nome);
  }

  public String getNome() {
    return nome;
  }
}
